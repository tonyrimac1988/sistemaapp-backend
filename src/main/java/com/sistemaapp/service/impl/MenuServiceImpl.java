package com.sistemaapp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistemaapp.model.Menu;
import com.sistemaapp.repo.IMenuRepo;
import com.sistemaapp.repo.ISubMenuRepo;
import com.sistemaapp.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

	private static final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

	@Autowired
	private IMenuRepo imenuRepo;

	@Autowired
	private ISubMenuRepo submenuRepo;

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
		return imenuRepo.findAll(Sort.by("nIdMenu").descending());
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
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdMenu").descending());
		return imenuRepo.findAll(pageSortedBy);
	}

	@Transactional
	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		String[] data = imenuRepo.MenuUsuario(nombre); // { "CONFIGURACIÓN", "ADMINISTRADOR" };
		List<Menu> menus_ = imenuRepo.findAll(Sort.by("nOrden").ascending());

		List<Menu> menus_resultado = new ArrayList<>();
		for (Menu menu : menus_) {
//			log.info("MenuServiceImpl->  " + menu.getSNombreMenu());
			int contador = 0;
			for (String data_ : data) {
				if (menu.getSNombreMenu().equals(data[contador])) {
					menus_resultado.add(menu);
					break;
				}
				contador++;
			}
		}
		return menus_resultado;
	}

	@Override
	public List<Menu> listarMenuPorNombreMenu(String key) {
		
		List<Object[]> lista =imenuRepo.listarMenuPorNombreMenu(key); 
		
		for (Object[] objects : lista) {
			log.info(lista.toString());
		}
		
		return null;
	}

}
