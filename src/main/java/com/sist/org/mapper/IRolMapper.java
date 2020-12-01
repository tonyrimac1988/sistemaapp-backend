package com.sist.org.mapper;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Rol;

public interface IRolMapper {

	String insertarRol(@Valid Rol rol);

	List<Rol> listarRol();

	String actualizarRol(@Valid Rol rol);

	String eliminarRol(@Valid Rol rol);

	Integer ListarAreaUsuario(Integer idUsuario);

}