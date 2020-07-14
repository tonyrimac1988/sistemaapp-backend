package com.sistemaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.SubMenu;
import com.sistemaapp.repo.ISubMenuRepo;
import com.sistemaapp.service.ISubMenuService;

@Service
public class SubMenuServiceImpl implements ISubMenuService{
	
	@Autowired
	private ISubMenuRepo isubRepo;

	@Override
	public SubMenu registrar(SubMenu obj) {
		// TODO Auto-generated method stub
		return isubRepo.save(obj);
	}

	@Override
	public SubMenu modificar(SubMenu obj) {
		// TODO Auto-generated method stub
		return isubRepo.save(obj);
	}

	@Override
	public List<SubMenu> listar() {
		// TODO Auto-generated method stub
		return isubRepo.findAll(Sort.by("norden").descending());
	}

	@Override
	public SubMenu listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<SubMenu> are = isubRepo.findById(v);
		return are.isPresent() ? are.get() : new SubMenu();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		isubRepo.deleteById(v);
	}

	@Override
	public Page<SubMenu> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("norden").descending());
		return isubRepo.findAll(pageSortedBy);
	}
	
 	
}
