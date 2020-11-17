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
import com.sistemaapp.model.Area;
import com.sistemaapp.repo.IAreaRepo;
import com.sistemaapp.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService{
	
	private static final Logger log = LoggerFactory.getLogger(AreaServiceImpl.class);
	
	@Autowired
	private IAreaRepo iareaRepo;
	
	@Autowired
    private IReportUtil reporte;

	@Override
	public Area registrar(Area obj) {
		// TODO Auto-generated method stub
		return iareaRepo.save(obj);		
	}

	@Override
	public Area modificar(Area obj) {
		// TODO Auto-generated method stub
		return iareaRepo.save(obj);
	}

	@Override
	public List<Area> listar() {
		// TODO Auto-generated method stub
		return iareaRepo.findAll(Sort.by("nidarea").descending());
	}

	@Override
	public Area listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Area> are = iareaRepo.findById(v);
		return are.isPresent() ? are.get() : new Area();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		iareaRepo.deleteById(v);
	}

	@Override
	public Page<Area> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nidarea").descending());
		return iareaRepo.findAll(pageSortedBy);
	}

	@Override
	public byte[] generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
		byte[] data = null;
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/area/AreaReport.jasper").getFile();
						
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
