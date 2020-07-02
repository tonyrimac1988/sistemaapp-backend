package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Sede;
import com.sistemaapp.repo.ISedeRepo;
import com.sistemaapp.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService{
	
	@Autowired
	private ISedeRepo isedeRepo;

	@Override
	public Sede registrar(Sede obj) {
		// TODO Auto-generated method stub
		return isedeRepo.save(obj);
	}

	@Override
	public Sede modificar(Sede obj) {
		// TODO Auto-generated method stub
		return isedeRepo.save(obj);
	}

	@Override
	public List<Sede> listar() {
		// TODO Auto-generated method stub
		return isedeRepo.findAll(Sort.by("nIdSede").descending());
	}

	@Override
	public Sede listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Sede> sede = isedeRepo.findById(v);
		return sede.isPresent() ? sede.get() : new Sede();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		isedeRepo.deleteById(v);
		
	}

	@Override
	public Page<Sede> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdSede").descending());
		return isedeRepo.findAll(pageSortedBy);
	}

}
