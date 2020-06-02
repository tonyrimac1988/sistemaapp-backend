package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Menu;
import com.sistemaapp.repo.IMenuRepo;
import com.sistemaapp.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService{
	
	@Autowired
	private IMenuRepo imenuRepo;

	@Override
	public Menu registrar(Menu obj) {
		// TODO Auto-generated method stub
		return imenuRepo.save(obj);
	}

	@Override
	public Menu modificar(Menu obj) {
		// TODO Auto-generated method stub
		return imenuRepo.save(obj);
	}

	@Override
	public List<Menu> listar() {
		// TODO Auto-generated method stub
		return imenuRepo.findAll();
	}

	@Override
	public Menu listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Menu> men = imenuRepo.findById(v);
		return men.isPresent() ? men.get() : new Menu();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		imenuRepo.deleteById(v);
	}
	

	@Override
	public Page<Menu> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return imenuRepo.findAll(pageable);
	}

}
