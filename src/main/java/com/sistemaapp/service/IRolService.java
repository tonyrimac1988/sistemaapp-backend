package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Rol;

public interface IRolService extends ICRUD<Rol, Integer>{
	
	Page<Rol> listarPageable(Pageable pageable);

}
