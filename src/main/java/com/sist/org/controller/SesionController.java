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
		//String idsesion = iSesionService.InciarSesion(usuario);
		//return new ResponseEntity<String>(idsesion, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iSesionService.InciarSesion(usuario), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método InciarSesion -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/cerrarsesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> CerrarSesion(@Validated @RequestBody int usuario) {
		//Integer idsesion = iSesionService.CerrarSesion(usuario);
		//return new ResponseEntity<Integer>(idsesion, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iSesionService.CerrarSesion(usuario).toString(), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método CerrarSesion -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
