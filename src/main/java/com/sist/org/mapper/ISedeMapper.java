package com.sist.org.mapper;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Sede;

public interface ISedeMapper {

	String insertarSede(@Valid Sede sede);

	List<Sede> listarSede();

	String actualizarSede(@Valid Sede sede);

	String eliminarSede(@Valid Sede sede);

}