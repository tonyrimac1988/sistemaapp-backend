package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.SubMenu;
import com.sistemaapp.repo.ISubMenuRepo;
import com.sistemaapp.service.ISubMenuService;

@Service
public class SubMenuServiceImpl implements ISubMenuService{
	
	@Autowired
	private ISubMenuRepo repo;

	@Override
	public SubMenu registrar(SubMenu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubMenu modificar(SubMenu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubMenu> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubMenu listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<SubMenu> are = repo.findById(v);
		return are.isPresent() ? are.get() : new SubMenu();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		
	}

 
	
	
	

}
