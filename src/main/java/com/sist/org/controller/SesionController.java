package com.sist.org.controller;

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
import com.sist.org.service.ISesionService;

@RestController
@RequestMapping("/sesiones")
public class SesionController {

		
	
	@Autowired
	ISesionService iSesionService;

	
	@PostMapping(value = "/inciarsesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> InciarSesion(@Validated @RequestBody String usuario) {
		
		RespuestaBase<Object> respuestabase = new RespuestaBase<Object>();		
		try {			
			respuestabase.setMensaje(iSesionService.InciarSesion(usuario));
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setData(null);						
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);					
		} catch (Exception e) {			
			respuestabase.setMensaje("Hubo un error en el método InciarSesion -> "+e.toString());
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setData(null);			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);					
		}
	}

	@PostMapping(value = "/cerrarsesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> CerrarSesion(@Validated @RequestBody int usuario) {
				
		RespuestaBase<Object> respuestabase = new RespuestaBase<Object>();				
		try {			
			respuestabase.setMensaje(iSesionService.CerrarSesion(usuario).toString());
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setData(null);						
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {			
			respuestabase.setMensaje("Hubo un error en el método CerrarSesion -> "+e.toString());
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setData(null);
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
