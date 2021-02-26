package com.sist.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.dto.SesionDTO;
import com.sist.org.mapper.IAuditoriaMapper;
import com.sist.org.service.IAuditoriaService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@Service
public class AuditoriaServiceImpl implements IAuditoriaService{

	
	@Autowired
	IAuditoriaMapper auditoriaMapper;
	
	@Override
	public Page<SesionDTO> listarSesiones(Pageable pageable) {
		
		Page<SesionDTO> page = new Page<>();
		
		if(pageable.getPalabraClave()== null ) {
			  pageable.setPalabraClave("");
		}
			page.setContent(auditoriaMapper.listarSesiones(pageable));	
			page.setTotalElements(auditoriaMapper.countSesiones(pageable));
			
		return page;
		 
	}
	

}
