package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Rol;
import com.sistemaapp.repo.IRolRepo;
import com.sistemaapp.service.IRolService;

@Service
public class RolServiceImpl implements IRolService{
	
	@Autowired
	private IRolRepo irolRepo;

	@Override
	public Rol registrar(Rol obj) {
		// TODO Auto-generated method stub
		return irolRepo.save(obj);
	}

	@Override
	public Rol modificar(Rol obj) {
		// TODO Auto-generated method stub
		return irolRepo.save(obj);
	}

	@Override
	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return irolRepo.findAll();
	}

	@Override
	public Rol listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Rol> rol = irolRepo.findById(v);
		return rol.isPresent() ? rol.get() : new Rol();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		irolRepo.deleteById(v);
	}

	@Override
	public Page<Rol> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return irolRepo.findAll(pageable);
	}

}
