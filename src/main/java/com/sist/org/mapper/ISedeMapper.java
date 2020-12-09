package com.sist.org.mapper;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Sede;
import com.sist.org.util.Pageable;

public interface ISedeMapper {

	String insertarSede(@Valid Sede sede);

	List<Sede> listarSede();

	String actualizarSede(@Valid Sede sede);

	String eliminarSede(@Valid Sede sede);

	List<Sede> listarSedePage(Pageable pageable);

	int countElements();

}