package com.sist.org.mapper;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.dto.SedeDTO;
import com.sist.org.util.Pageable;

public interface ISedeMapper {

	String insertarSede(@Valid SedeDTO sede);

	List<SedeDTO> listarSede();

	String actualizarSede(@Valid SedeDTO sede);

	String eliminarSede(@Valid SedeDTO sede);

	List<SedeDTO> listarSedePage(Pageable pageable);

	int countElements();

}