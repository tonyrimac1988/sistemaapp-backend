package com.sist.org.mapper;

import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Area;

public interface IAreaMapper {

	String insertarArea(@Valid Area area);

	List<Area> listarArea();

	String actualizarArea(@Valid Area area);

	String eliminarArea(@Valid Area area);

}
