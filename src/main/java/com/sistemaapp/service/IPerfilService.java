package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.Perfil;

public interface IPerfilService extends ICRUD<Perfil, Integer>{
	
	Page<Perfil> listarPageable(Pageable pageable);

}
