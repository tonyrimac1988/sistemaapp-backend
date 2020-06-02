package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Sesion;
import com.sistemaapp.repo.ISesionRepo;
import com.sistemaapp.service.ISesionService;

@Service
public class SesionServiceImpl implements ISesionService{
	
	@Autowired
	private ISesionRepo isesionRepo;

	@Override
	public Sesion registrar(Sesion obj) {
		// TODO Auto-generated method stub
		return isesionRepo.save(obj);
	}

	@Override
	public Sesion modificar(Sesion obj) {
		// TODO Auto-generated method stub
		return isesionRepo.save(obj);
	}

	@Override
	public List<Sesion> listar() {
		// TODO Auto-generated method stub
		return isesionRepo.findAll();
	}

	@Override
	public Sesion listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Sesion> ses = isesionRepo.findById(v);
		return ses.isPresent() ? ses.get() : new Sesion();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		isesionRepo.deleteById(v);
	}

	@Override
	public Page<Sesion> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return isesionRepo.findAll(pageable);
	}

}
