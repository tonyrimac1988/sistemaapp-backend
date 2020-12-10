package com.sist.org.service.impl;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.IRolMapper;
import com.sist.org.modelo.Rol;
import com.sist.org.service.IRolService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	IRolMapper rolmapper;
	
	@Override
	public String insertarRol(@Valid Rol rol) {
		// TODO Auto-generated method stub
		return rolmapper.insertarRol(rol);
	}

	@Override
	public List<Rol> listarRol() {
		// TODO Auto-generated method stub
		return rolmapper.listarRol();
	}

	@Override
	public String actualizarRol(@Valid Rol rol) {
		// TODO Auto-generated method stub
		return rolmapper.actualizarRol(rol);
	}

	@Override
	public String eliminarRol(@Valid Rol rol) {
		// TODO Auto-generated method stub
		return rolmapper.eliminarRol(rol);
	}

	@Override
	public Integer ListarAreaUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return rolmapper.ListarAreaUsuario(idUsuario);
	}

	@Override
	public Page<Rol> listarRolPage(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Rol> page = new Page<>();
		page.setContent(rolmapper.listarRolPage(pageable));
		page.setTotalElements(rolmapper.countElements());
		
		return page;
	}

}