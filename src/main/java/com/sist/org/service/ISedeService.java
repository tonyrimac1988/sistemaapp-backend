package com.sist.org.service;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.dto.SedeDTO;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

public interface ISedeService {

	String insertarSede(@Valid SedeDTO sede);

	List<SedeDTO> listarSede();

	String actualizarSede(@Valid SedeDTO sede);

	String eliminarSede(@Valid SedeDTO sede);

	Page<SedeDTO> listarSedePage(Pageable pageable);

}
