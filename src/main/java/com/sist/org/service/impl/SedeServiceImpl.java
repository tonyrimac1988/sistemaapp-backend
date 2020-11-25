package com.sist.org.service.impl;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.ISedeMapper;
import com.sist.org.modelo.Sede;
import com.sist.org.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService{

	@Autowired
	ISedeMapper sedemapper;
	
	@Override
	public String insertarSede(@Valid Sede sede) {
		// TODO Auto-generated method stub
		return sedemapper.insertarSede(sede);
	}

	@Override
	public List<Sede> listarSede() {
		// TODO Auto-generated method stub
		return sedemapper.listarSede();
	}

	@Override
	public String actualizarSede(@Valid Sede sede) {
		// TODO Auto-generated method stub
		return sedemapper.actualizarSede(sede);
	}

	@Override
	public String eliminarSede(@Valid Sede sede) {
		// TODO Auto-generated method stub
		return sedemapper.eliminarSede(sede);
	}
	

}
