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
import com.sistemaapp.model.Perfil;
import com.sistemaapp.repo.IPerfilRepo;
import com.sistemaapp.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService{
	
	private static final Logger log = LoggerFactory.getLogger(PerfilServiceImpl.class);
	
	@Autowired
	private IPerfilRepo iperfilRepo;
	
	 @Autowired
	    private IReportUtil reporte;

	@Override
	public Perfil registrar(Perfil obj) {
		// TODO Auto-generated method stub
		return iperfilRepo.save(obj);
	}

	@Override
	public Perfil modificar(Perfil obj) {
		// TODO Auto-generated method stub
		return iperfilRepo.save(obj);
	}

	@Override
	public List<Perfil> listar() {
		// TODO Auto-generated method stub
		return iperfilRepo.findAll(Sort.by("nidperfil").descending());
	}

	@Override
	public Perfil listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Perfil> per = iperfilRepo.findById(v);
		return per.isPresent() ? per.get() : new Perfil();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		iperfilRepo.deleteById(v);
	}

	@Override
	public Page<Perfil> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nidperfil").descending());
		return iperfilRepo.findAll(pageSortedBy);
	}

	@Override
	public byte[] generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
		byte[] data = null;
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/menu/MenuReport.jasper").getFile();
					
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
