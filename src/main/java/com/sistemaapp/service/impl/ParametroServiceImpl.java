package com.sistemaapp.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistemaapp._util.IReportUtil;
import com.sistemaapp.model.Parametro;
import com.sistemaapp.repo.IParametroRepo;
import com.sistemaapp.service.IParametroService;

@Service
public class ParametroServiceImpl implements IParametroService{
	
	private static final Logger log = LoggerFactory.getLogger(PerfilServiceImpl.class);
	
	@Autowired
	private IParametroRepo iparametroRepo;
	
	@Autowired
    private IReportUtil reporte;

	@Override
	public Parametro registrar(Parametro obj) {
		// TODO Auto-generated method stub
		return iparametroRepo.save(obj);
	}

	@Override
	public Parametro modificar(Parametro obj) {
		// TODO Auto-generated method stub
		return iparametroRepo.save(obj);
	}

	@Override
	public List<Parametro> listar() {
		// TODO Auto-generated method stub
		return iparametroRepo.findAll(Sort.by("nidparametro").descending());
	}

	@Override
	public Parametro listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Parametro> par = iparametroRepo.findById(v);
		return par.isPresent() ? par.get() : new Parametro();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		iparametroRepo.deleteById(v);
	}

	@Override
	public Page<Parametro> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nidparametro").descending());
		return iparametroRepo.findAll(pageSortedBy);
	}

	@Override
	public byte[] generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
		byte[] data = null;
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/parametro/ParametroReport.jasper").getFile();
					
			if(tipoReporte.equals("xlsx")) {
				
				log.info("xlsx");
				data = reporte.generarEXCEL(file, parametros);
				
			}else if (tipoReporte.equals("html")) {
				
				log.info("html");
				data = reporte.generarHTML(file, parametros);
			
			}else if (tipoReporte.equals("pdf")) {
				
				log.info("pdf");
				data = reporte.generarPDF(file, parametros);
				
			}else {
				
				log.info("FORMATO DE REPORTE DESCONOCIDO");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			log.info("ERRORRRRRRRRRR ");
		}
		return data;
	}
	
	

}
