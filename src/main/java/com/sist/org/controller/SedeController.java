package com.sist.org.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.modelo.Sede;
import com.sist.org.service.ISedeService;

@RestController
@RequestMapping("/sedes")
public class SedeController {
	
	@Autowired
	ISedeService isedeService;
	
	@PostMapping(value= "/insertarsede", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarSede(@Valid @RequestBody Sede sede){

		String respuesta = isedeService.insertarSede(sede);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}

	@GetMapping(value = "/listarsede", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sede>> listarSede() {

		List<Sede> listasede = isedeService.listarSede();

		return new ResponseEntity<List<Sede>>(listasede, HttpStatus.OK);
	}
	
	@PostMapping("/actualizarsede")
	public ResponseEntity<String> actualizarSede(@Valid @RequestBody Sede sede) {

		String respuesta = isedeService.actualizarSede(sede);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
	
	@PostMapping("/eliminarsede")
	public ResponseEntity<String> eliminarSede(@Valid @RequestBody Sede sede) {

		String respuesta = isedeService.eliminarSede(sede);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}

}
