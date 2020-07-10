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
import com.sistemaapp.model.Sesion;
import com.sistemaapp.repo.ISesionRepo;
import com.sistemaapp.service.ISesionService;

@Service
public class SesionServiceImpl implements ISesionService{
	
	private static final Logger log = LoggerFactory.getLogger(SesionServiceImpl.class);
	
	@Autowired
	private ISesionRepo isesionRepo;
	
	@Autowired
    private IReportUtil reporte;

	@Override
	public Sesion registrar(Sesion obj) {
		// TODO Auto-generated method stub
		return isesionRepo.save(obj);
	}

	@Override
	public Sesion modificar(Sesion obj) {
		// TODO Auto-generated method stub
		return isesionRepo.save(obj);
	}

	@Override
	public List<Sesion> listar() {
		// TODO Auto-generated method stub
		return isesionRepo.findAll(Sort.by("nIdSesion").descending());
	}

	@Override
	public Sesion listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Sesion> ses = isesionRepo.findById(v);
		return ses.isPresent() ? ses.get() : new Sesion();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		isesionRepo.deleteById(v);
	}

	@Override
	public Page<Sesion> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdSesion").descending());
		return isesionRepo.findAll(pageSortedBy);
	}

	@Override
	public byte[] generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
		byte[] data = null;
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/sesion/SesionReport.jasper").getFile();
							
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
