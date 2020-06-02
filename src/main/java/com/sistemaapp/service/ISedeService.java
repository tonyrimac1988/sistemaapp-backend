package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Sede;

public interface ISedeService extends ICRUD<Sede, Integer>{
	
	Page<Sede> listarPageable(Pageable pageable);

}
