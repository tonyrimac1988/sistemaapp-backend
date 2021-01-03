package com.sist.org.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.HtmlResourceHandler;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;


@Service
public class IReportUtil {

	private static final Logger log = LoggerFactory.getLogger(IReportUtil.class);
	
	@Autowired
	private DataSource dataSource;

	
	/* HTML */
	public byte[] generarHTML(File file, Map<String, Object> parametros) {
		byte[] data = null;

		try {
  
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros,  dataSource.getConnection());
			
			final Map<String, String> images = new HashMap<>();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			HtmlExporter exporterHTML = new HtmlExporter();
			SimpleExporterInput exporterInput = new SimpleExporterInput(print);
			exporterHTML.setExporterInput(exporterInput);
			SimpleHtmlExporterOutput simpleHtmlExporterOutput = new SimpleHtmlExporterOutput(outputStream);
			exporterHTML.setExporterOutput(simpleHtmlExporterOutput);
			simpleHtmlExporterOutput.setImageHandler(new HtmlResourceHandler() {

				@Override
				public void handleResource(String id, byte[] data) {
					images.put(id, "data:image/gif;base64," + new String(Base64.encodeBase64(data)));
				}

				@Override
				public String getResourcePath(String id) {
					return images.get(id);
				}
			});
			exporterHTML.exportReport();
			data = outputStream.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	/* EXCEL */
	public byte[] generarEXCEL(File file, Map<String, Object> parametros ) {
		byte[] data = null;

		try {

			//log.info("Genera reporte excel "+file.toString());
			//log.info("Genera reporte excel "+dataSource.getConnection());
			
			parametros = new HashMap<>();
				
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros,  dataSource.getConnection());
			
			/* EXCEL https://www.baeldung.com/spring-jasper */
			ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
			JRXlsxExporter xlsexporter = new JRXlsxExporter();
			SimpleXlsxReportConfiguration xlsreportConfig = new SimpleXlsxReportConfiguration();
			xlsreportConfig.setSheetNames(new String[] { "Employee Data" });
			xlsexporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport));
			xlsexporter.setExporterInput(new SimpleExporterInput(print));
			xlsexporter.setConfiguration(xlsreportConfig);
			xlsexporter.exportReport();			
			data = xlsReport.toByteArray();			
			//log.info("Excel "+data.length);

		} catch (Exception e) {
			log.info("Error "+e.toString());
			e.printStackTrace();
		}

		return data;

	}

	/* PDF */
	public byte[] generarPDF(File file, Map<String, Object> parametros  ) {
		byte[] data = null;

		try { 
			
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros,  dataSource.getConnection());
			
			data =  JasperExportManager.exportReportToPdf(print);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;

	}

}
