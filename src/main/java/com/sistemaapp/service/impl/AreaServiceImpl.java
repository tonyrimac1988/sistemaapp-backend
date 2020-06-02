package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Area;
import com.sistemaapp.repo.IAreaRepo;
import com.sistemaapp.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService{
	
	@Autowired
	private IAreaRepo iareaRepo;

	@Override
	public Area registrar(Area obj) {
		// TODO Auto-generated method stub
		return iareaRepo.save(obj);		
	}

	@Override
	public Area modificar(Area obj) {
		// TODO Auto-generated method stub
		return iareaRepo.save(obj);
	}

	@Override
	public List<Area> listar() {
		// TODO Auto-generated method stub
		return iareaRepo.findAll();
	}

	@Override
	public Area listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Area> are = iareaRepo.findById(v);
		return are.isPresent() ? are.get() : new Area();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		iareaRepo.deleteById(v);
	}

	@Override
	public Page<Area> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return iareaRepo.findAll(pageable);
	}

}
