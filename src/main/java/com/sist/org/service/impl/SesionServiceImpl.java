package com.sist.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.ISesionMapper;
import com.sist.org.service.ISesionService;

@Service
public class SesionServiceImpl implements ISesionService {

	@Autowired
	ISesionMapper iSesionMapper;

	@Override
	public String InciarSesion(String usuario) {
		// TODO Auto-generated method stub
		return iSesionMapper.InciarSesion(usuario);
	}

	@Override
	public Integer CerrarSesion(int usuario) {
		// TODO Auto-generated method stub
		return iSesionMapper.CerrarSesion(usuario);
	}

}
