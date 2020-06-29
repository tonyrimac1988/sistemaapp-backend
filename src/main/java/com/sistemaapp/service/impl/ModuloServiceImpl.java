package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Modulo;
import com.sistemaapp.repo.IModuloRepo;
import com.sistemaapp.service.IModuloService;

@Service
public class ModuloServiceImpl implements IModuloService{
	
	@Autowired
	private IModuloRepo imoduloRepo;

	@Override
	public Modulo registrar(Modulo obj) {
		// TODO Auto-generated method stub
		return imoduloRepo.save(obj);
	}

	@Override
	public Modulo modificar(Modulo obj) {
		// TODO Auto-generated method stub
		return imoduloRepo.save(obj);
	}

	@Override
	public List<Modulo> listar() {
		// TODO Auto-generated method stub
		return imoduloRepo.findAll(Sort.by("nIdModulo").descending());
	}

	@Override
	public Modulo listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Modulo> mod = imoduloRepo.findById(v);
		return mod.isPresent() ? mod.get() : new Modulo();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		imoduloRepo.deleteById(v);
		
	}

	@Override
	public Page<Modulo> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdModulo").descending());		
		return imoduloRepo.findAll(pageSortedBy);
	}
	
}
