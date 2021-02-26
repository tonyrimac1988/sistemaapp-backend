package com.sist.org.mapper;

import java.util.List;

import com.sist.org.dto.SesionDTO;
import com.sist.org.util.Pageable;

public interface IAuditoriaMapper {

	List<SesionDTO> listarSesiones(Pageable pageable);

	int countSesiones(Pageable pageable);

}
