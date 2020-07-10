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
import com.sistemaapp.model.Sede;
import com.sistemaapp.repo.ISedeRepo;
import com.sistemaapp.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService{
	
	private static final Logger log = LoggerFactory.getLogger(SedeServiceImpl.class);
	
	@Autowired
	private ISedeRepo isedeRepo;
	
	@Autowired
    private IReportUtil reporte;

	@Override
	public Sede registrar(Sede obj) {
		// TODO Auto-generated method stub
		return isedeRepo.save(obj);
	}

	@Override
	public Sede modificar(Sede obj) {
		// TODO Auto-generated method stub
		return isedeRepo.save(obj);
	}

	@Override
	public List<Sede> listar() {
		// TODO Auto-generated method stub
		return isedeRepo.findAll(Sort.by("nIdSede").descending());
	}

	@Override
	public Sede listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Sede> sede = isedeRepo.findById(v);
		return sede.isPresent() ? sede.get() : new Sede();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		isedeRepo.deleteById(v);
		
	}

	@Override
	public Page<Sede> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdSede").descending());
		return isedeRepo.findAll(pageSortedBy);
	}

	@Override
	public byte[] generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
		byte[] data = null;
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/sede/SedeReport.jasper").getFile();
							
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
