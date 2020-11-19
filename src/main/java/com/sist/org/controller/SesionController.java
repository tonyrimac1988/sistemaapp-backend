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

import com.sist.org.service.ISesionService;

@RestController
@RequestMapping("/sesiones")
public class SesionController {

	@Autowired
	ISesionService iSesionService;

	@PostMapping(value = "/inciarsesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> InciarSesion(@Validated @RequestBody String usuario) {
		String idsesion = iSesionService.InciarSesion(usuario);
		return new ResponseEntity<String>(idsesion, HttpStatus.OK);
	}

	@PostMapping(value = "/cerrarsesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> CerrarSesion(@Validated @RequestBody int usuario) {
		Integer idsesion = iSesionService.CerrarSesion(usuario);
		return new ResponseEntity<Integer>(idsesion, HttpStatus.OK);
	}

}
