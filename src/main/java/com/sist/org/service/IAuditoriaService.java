package com.sist.org.service;

import com.sist.org.dto.SesionDTO;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

public interface IAuditoriaService {

	Page<SesionDTO> listarSesiones(Pageable pageable);

}
