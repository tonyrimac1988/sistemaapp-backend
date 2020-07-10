package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario, Integer>{
	
	Page<Usuario> listarPageable(Pageable pageable);

	byte[] generarReporte(String tipoReporte);

	
}
