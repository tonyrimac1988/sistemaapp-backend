package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Parametro;

public interface IParametroService extends ICRUD<Parametro, Integer>{
	
	Page<Parametro> listarPageable(Pageable pageable);
	
	byte[] generarReporte(String tipoReporte);

}
