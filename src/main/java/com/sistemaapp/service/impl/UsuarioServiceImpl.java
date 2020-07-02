package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Usuario;
import com.sistemaapp.repo.IUsuarioRepo;
import com.sistemaapp.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepo iusuarioRepo;

	@Override
	public Usuario registrar(Usuario obj) {
		// TODO Auto-generated method stub
		return iusuarioRepo.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		// TODO Auto-generated method stub
		return iusuarioRepo.save(obj);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return iusuarioRepo.findAll(Sort.by("nIdUsuario").descending());
	}

	@Override
	public Usuario listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Usuario> usu = iusuarioRepo.findById(v);
		return usu.isPresent() ? usu.get() : new Usuario();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		iusuarioRepo.deleteById(v);
	}

	@Override
	public Page<Usuario> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdUsuario").descending());
		return iusuarioRepo.findAll(pageSortedBy);
	}

}
