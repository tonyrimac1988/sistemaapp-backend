package com.sist.org.mapper;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Perfil;

public interface IPerfilMapper {

	String insertarPerfil(@Valid Perfil perfil);
	
	List<Perfil> listarPerfil();

	String actualizarPerfil(@Valid Perfil perfil);

	String eliminarPerfil(@Valid Perfil perfil);
	
}