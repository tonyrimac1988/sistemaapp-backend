package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Menu;

public interface IMenuService extends ICRUD<Menu, Integer>{
	
	Page<Menu> listarPageable(Pageable pageable);

}
