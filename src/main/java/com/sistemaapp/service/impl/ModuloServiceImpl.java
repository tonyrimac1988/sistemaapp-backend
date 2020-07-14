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
import com.sistemaapp.model.Modulo;
import com.sistemaapp.repo.IModuloRepo;
import com.sistemaapp.service.IModuloService;

@Service
public class ModuloServiceImpl implements IModuloService{
	
	private static final Logger log = LoggerFactory.getLogger(ModuloServiceImpl.class);
	
	@Autowired
	private IModuloRepo imoduloRepo;
	
	@Autowired
    private IReportUtil reporte;

	@Override
	public Modulo registrar(Modulo obj) {
		// TODO Auto-generated method stub
		return imoduloRepo.save(obj);
	}

	@Override
	public Modulo modificar(Modulo obj) {
		// TODO Auto-generated method stub
		return imoduloRepo.save(obj);
	}

	@Override
	public List<Modulo> listar() {
		// TODO Auto-generated method stub
		return imoduloRepo.findAll(Sort.by("nidmodulo").descending());
	}

	@Override
	public Modulo listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Modulo> mod = imoduloRepo.findById(v);
		return mod.isPresent() ? mod.get() : new Modulo();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		imoduloRepo.deleteById(v);
		
	}

	@Override
	public Page<Modulo> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nidmodulo").descending());		
		return imoduloRepo.findAll(pageSortedBy);
	}

	@Override
	public byte[] generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
byte[] data = null;
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/modulo/ModuloReport.jasper").getFile();
			
			
			
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
