package com.sistemaapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Menu;

public interface IMenuService extends ICRUD<Menu, Integer>{
	
	Page<Menu> listarPageable(Pageable pageable);

	List<Menu> listarMenuPorUsuario(String nombre);
	
	List<Menu> listarMenuPorNombreMenu(String key);

	byte[] generarReporte(String tipoReporte);

}
