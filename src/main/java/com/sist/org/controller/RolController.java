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

import com.sist.org.modelo.Rol;
import com.sist.org.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolController {	

	@Autowired
	IRolService irolService;
	
	@PostMapping(value= "/insertarRol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarRol(@Valid @RequestBody Rol rol){

		String respuesta = irolService.insertarRol(rol);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
	
	@GetMapping(value = "/listarRol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rol>> listarRol() {

		List<Rol> listarol = irolService.listarRol();

		return new ResponseEntity<List<Rol>>(listarol, HttpStatus.OK);
	}

	@PostMapping("/actualizarol")
	public ResponseEntity<String> actualizarRol(@Valid @RequestBody Rol rol) {

		String respuesta = irolService.actualizarRol(rol);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
	
	@PostMapping("/eliminarol")
	public ResponseEntity<String> eliminarRol(@Valid @RequestBody Rol rol) {

		String respuesta = irolService.eliminarRol(rol);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
}
