package com.sist.org.mapper;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Perfil;
import com.sist.org.util.Pageable;

public interface IPerfilMapper {

	String insertarPerfil(@Valid Perfil perfil);
	
	List<Perfil> listarPerfil();

	String actualizarPerfil(@Valid Perfil perfil);

	String eliminarPerfil(@Valid Perfil perfil);

	Integer listarMenuPorUsuario(Integer idusuario);

	List<Perfil> listarPerfilPage(Pageable pageable);

	int countElements();
	
}