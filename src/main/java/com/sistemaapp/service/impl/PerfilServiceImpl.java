package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Perfil;
import com.sistemaapp.repo.IPerfilRepo;
import com.sistemaapp.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService{
	
	@Autowired
	private IPerfilRepo iperfilRepo;

	@Override
	public Perfil registrar(Perfil obj) {
		// TODO Auto-generated method stub
		return iperfilRepo.save(obj);
	}

	@Override
	public Perfil modificar(Perfil obj) {
		// TODO Auto-generated method stub
		return iperfilRepo.save(obj);
	}

	@Override
	public List<Perfil> listar() {
		// TODO Auto-generated method stub
		return iperfilRepo.findAll(Sort.by("nIdPerfil").descending());
	}

	@Override
	public Perfil listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Perfil> per = iperfilRepo.findById(v);
		return per.isPresent() ? per.get() : new Perfil();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		iperfilRepo.deleteById(v);
	}

	@Override
	public Page<Perfil> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdPerfil").descending());
		return iperfilRepo.findAll(pageSortedBy);
	}

}
