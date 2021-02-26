package com.sist.org.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.dto.RespuestaBase;
import com.sist.org.dto.SesionDTO;
import com.sist.org.service.IAuditoriaService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;


@RestController
@RequestMapping("/auditorias")
public class AuditoriaController {

	@Autowired
	IAuditoriaService auditoriaService;

	@PostMapping(value = "/listarSesiones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<SesionDTO>>> listarSesiones(@Validated @RequestBody Pageable pageable) {

		RespuestaBase<Page<SesionDTO>> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(auditoriaService.listarSesiones(pageable)));

			return new ResponseEntity<RespuestaBase<Page<SesionDTO>>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo NOMBRE_FUNCION -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Page<SesionDTO>>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}
	
	
 
}
