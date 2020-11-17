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
import com.sistemaapp.model.Rol;
import com.sistemaapp.repo.IRolRepo;
import com.sistemaapp.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{
	
	private static final Logger log = LoggerFactory.getLogger(RolServiceImpl.class);
	
	@Autowired
	private IRolRepo irolRepo;
	
	@Autowired
    private IReportUtil reporte;

	@Override
	public Rol registrar(Rol obj) {
		// TODO Auto-generated method stub
		return irolRepo.save(obj);
	}

	@Override
	public Rol modificar(Rol obj) {
		// TODO Auto-generated method stub
		return irolRepo.save(obj);
	}

	@Override
	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return irolRepo.findAll(Sort.by("nidrol").descending());
	}

	@Override
	public Rol listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Rol> rol = irolRepo.findById(v);
		return rol.isPresent() ? rol.get() : new Rol();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		irolRepo.deleteById(v);
	}

	@Override
	public Page<Rol> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nidrol").descending());
		return irolRepo.findAll(pageSortedBy);
	}

	@Override
	public byte[] generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
		byte[] data = null;
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/rol/RolReport.jasper").getFile();
						
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
