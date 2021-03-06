package com.sist.org.service;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Perfil;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

public interface IPerfilService {

	String insertarPerfil(@Valid Perfil perfil);
	
	List<Perfil> listarPerfil();
	
	String actualizarPerfil(@Valid Perfil perfil);

	String eliminarPerfil(@Valid Perfil perfil);

	Integer listarMenuPorUsuario(Integer idusuario);

	Page<Perfil> listarPerfilPage(Pageable pageable);


}
