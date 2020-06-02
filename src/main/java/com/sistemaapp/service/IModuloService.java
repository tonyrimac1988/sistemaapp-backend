package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Modulo;

public interface IModuloService extends ICRUD<Modulo, Integer>{
	
	Page<Modulo> listarPageable(Pageable pageable);

}
