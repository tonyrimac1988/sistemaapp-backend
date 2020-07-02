package com.sistemaapp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ibm.icu.text.SimpleDateFormat;
import com.sistemaapp.model.Menu;
import com.sistemaapp.repo.IMenuRepo;
import com.sistemaapp.repo.ISubMenuRepo;
import com.sistemaapp.service.IMenuService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@Service
public class MenuServiceImpl implements IMenuService {

	private static final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

	@Autowired
	private IMenuRepo imenuRepo;

	
    @Autowired
    private DataSource dataSource;
    	
	@Autowired
	private ISubMenuRepo submenuRepo;

	@Override
	public Menu registrar(Menu obj) {
		// TODO Auto-generated method stub
		return imenuRepo.save(obj);
	}

	@Override
	public Menu modificar(Menu obj) {
		// TODO Auto-generated method stub
		return imenuRepo.save(obj);
	}

	@Override
	public List<Menu> listar() {
		// TODO Auto-generated method stub
		return imenuRepo.findAll(Sort.by("nIdMenu").descending());
	}

	@Override
	public Menu listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Menu> men = imenuRepo.findById(v);
		return men.isPresent() ? men.get() : new Menu();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		imenuRepo.deleteById(v);
	}

	@Override
	public Page<Menu> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdMenu").descending());
		return imenuRepo.findAll(pageSortedBy);
	}

	@Transactional
	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		String[] data = imenuRepo.MenuUsuario(nombre); // { "CONFIGURACIÓN", "ADMINISTRADOR" };
		List<Menu> menus_ = imenuRepo.findAll(Sort.by("nOrden").ascending());

		List<Menu> menus_resultado = new ArrayList<>();
		for (Menu menu : menus_) {
//			log.info("MenuServiceImpl->  " + menu.getSNombreMenu());
			int contador = 0;
			for (String data_ : data) {
				if (menu.getSNombreMenu().equals(data[contador])) {
					menus_resultado.add(menu);
					break;
				}
				contador++;
			}
		}
		return menus_resultado;
	}

	@Override
	public List<Menu> listarMenuPorNombreMenu(String key) {
		
		List<Object[]> lista =imenuRepo.listarMenuPorNombreMenu(key); 
		
		for (Object[] objects : lista) {
			log.info(lista.toString());
		}
		
		return null;
	}

	@Override
	public byte[] generarReporte() {

		byte[] data = null;

		try {
			
			Map<String, Object> parametros = new HashMap<>();
				
			File file = new ClassPathResource("/reportes/menu/MenuReport.jasper").getFile();			
			JasperPrint xlsPrint = JasperFillManager.fillReport(file.getPath(), parametros, dataSource.getConnection());
			
//			ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();					
//			JRXlsExporter xlsExporter = new JRXlsExporter();
//			xlsExporter.setExporterInput(new SimpleExporterInput(xlsPrint));
//			xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsReport));
//			SimpleXlsReportConfiguration xlsReportConfiguration = new SimpleXlsReportConfiguration();
//	        xlsReportConfiguration.setOnePagePerSheet(false);
//	        xlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
//	        xlsReportConfiguration.setDetectCellType(false);
//	        xlsReportConfiguration.setWhitePageBackground(false);
//	        xlsExporter.setConfiguration(xlsReportConfiguration);
//	        xlsExporter.exportReport();	
//			data =  xlsReport.toByteArray() ; //JasperExportManager.exportReportToPdf(print);
			
			
			data =  JasperExportManager.exportReportToPdf(xlsPrint);
			log.info("---> genera reporte " +data.length);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("ERRORRRRRRRRRR ");
		}

		
		return data;
	}

	
	
	public void generateEXCEL(JasperPrint print) throws FileNotFoundException, JRException, IOException {
//--------------EXCEL---------------
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss");
		String now = ft.format(date);
		String excel = now + ".xls";
		OutputStream out2 = null;
		out2 = new FileOutputStream(new File("/" + excel));
		ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
// coding For Excel:
		JRXlsExporter exporterXLS = new JRXlsExporter();

		exporterXLS.exportReport();
		out2.write(byteArrayOutputStream2.toByteArray());
		out2.flush();
		out2.close();
	}
	
	
}



