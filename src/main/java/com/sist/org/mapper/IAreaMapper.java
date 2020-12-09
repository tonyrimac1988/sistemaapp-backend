package com.sist.org.mapper;

import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Area;
import com.sist.org.util.Pageable;

public interface IAreaMapper {

	String insertarArea(@Valid Area area);

	List<Area> listarArea();

	String actualizarArea(@Valid Area area);

	String eliminarArea(@Valid Area area);

	Integer ListarAreaUsuario(Integer idarea);

	List<Area> listarAreaPage(Pageable pageable);

	int countElements();

}
