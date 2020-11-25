package com.sist.org.service.impl;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.IModuloMapper;
import com.sist.org.modelo.Modulo;
import com.sist.org.service.IModuloService;

@Service
public class ModuloServiceImpl implements IModuloService{
	
	@Autowired
	IModuloMapper modulomapper;

	@Override
	public String insertarModulo(@Valid Modulo modulo) {
		// TODO Auto-generated method stub
		return modulomapper.insertarModulo(modulo);
	}

	@Override
	public List<Modulo> listarModulo() {
		// TODO Auto-generated method stub
		return modulomapper.listarModulo();
	}

	@Override
	public String actualizarModulo(@Valid Modulo modulo) {
		// TODO Auto-generated method stub
		return modulomapper.actualizarModulo(modulo);
	}

	@Override
	public String eliminarModulo(@Valid Modulo modulo) {
		// TODO Auto-generated method stub
		return modulomapper.eliminarModulo(modulo);
	}

}
