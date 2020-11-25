package com.sist.org.service.impl;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.IPerfilMapper;
import com.sist.org.modelo.Perfil;
import com.sist.org.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService{

	private static final Logger log = LoggerFactory.getLogger(PerfilServiceImpl.class);
	
	@Autowired
	IPerfilMapper perfilmapper;
	
	@Override
	public String insertarPerfil(@Valid Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilmapper.insertarPerfil(perfil);
	}

	@Override
	public List<Perfil> listarPerfil() {
		// TODO Auto-generated method stub
		return perfilmapper.listarPerfil();
	}
	
	@Override
	public String actualizarPerfil(@Valid Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilmapper.actualizarPerfil(perfil);
	}

	@Override
	public String eliminarPerfil(@Valid Perfil perfil) {
		// TODO Auto-generated method stub
		log.info("-------------------> "+perfil.getNidperfil());
		return perfilmapper.eliminarPerfil(perfil);
	}

	
}