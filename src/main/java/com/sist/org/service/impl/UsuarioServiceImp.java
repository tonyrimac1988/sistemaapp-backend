package com.sist.org.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.dto.UsuarioSesion;
import com.sist.org.mapper.IUsuarioMapper;
import com.sist.org.modelo.Operador;
import com.sist.org.modelo.Page;
import com.sist.org.modelo.Pageable;
import com.sist.org.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService{


	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImp.class);
	
	
	@Autowired
	IUsuarioMapper iUsuarioMapper;


	@Override
	public Page<Operador> listarUsuario(Pageable pageable) {
		// TODO Auto-generated method stub
		//log.info("--------------->  "+pageable.getPageNumber() +" "+pageable.getPageSize());
		
		Page<Operador> page = new Page<>();
		page.setContent(iUsuarioMapper.listarUsuario(pageable));
		page.setTotalElements(iUsuarioMapper.countElements());		
		return page;
	}


	@Override
	public UsuarioSesion ConsultaUsuariosesion(String usuario) {
		// TODO Auto-generated method stub
		return iUsuarioMapper.ConsultaUsuariosesion(usuario);
	}
	
	 

}
