package com.sist.org.service;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Sede;

public interface ISedeService {

	String insertarSede(@Valid Sede sede);

	List<Sede> listarSede();

	String actualizarSede(@Valid Sede sede);

	String eliminarSede(@Valid Sede sede);

}
