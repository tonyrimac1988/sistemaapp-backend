package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Sesion;

public interface ISesionService extends ICRUD<Sesion, Integer>{
	
	Page<Sesion> listarPageable(Pageable pageable);

}
