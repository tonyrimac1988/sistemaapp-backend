package com.sist.org.service;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Area;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

public interface IAreaService {

	String insertarArea(@Valid Area area);

	List<Area> listarArea();

	String actualizarArea(@Valid Area area);

	String eliminarArea(@Valid Area area);

	Integer ListarAreaUsuario(Integer idarea);

	Page<Area> listarAreaPage(Pageable pageable);

}
