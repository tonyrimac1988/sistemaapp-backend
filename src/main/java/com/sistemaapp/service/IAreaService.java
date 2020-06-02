package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Area;

public interface IAreaService extends ICRUD<Area, Integer>{
	
	Page<Area> listarPageable(Pageable pageable);
	
}
