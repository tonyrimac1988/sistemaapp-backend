package com.sist.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.IMenuMapper;
import com.sist.org.modelo.Menu;
import com.sist.org.service.IMenuService;


@Service
public class MenuServiceImpl implements IMenuService{

	@Autowired
	IMenuMapper iMenuMapper;
	
	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		// TODO Auto-generated method stub
		return iMenuMapper.listarMenuPorUsuario(nombre);
	}

}
