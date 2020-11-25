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

import com.sist.org.modelo.Modulo;
import com.sist.org.service.IModuloService;

@RestController
@RequestMapping("/modulos")
public class ModuloController {

	@Autowired
	IModuloService imoduloService;
	
	@PostMapping(value= "/insertarmodulo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarModulo(@Valid @RequestBody Modulo modulo){

		String respuesta = imoduloService.insertarModulo(modulo);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}

	@GetMapping(value = "/listarmodulo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Modulo>> listarModulo() {

		List<Modulo> listamodulo = imoduloService.listarModulo();

		return new ResponseEntity<List<Modulo>>(listamodulo, HttpStatus.OK);
	}
	
	@PostMapping("/actualizarmodulo")
	public ResponseEntity<String> actualizarModulo(@Valid @RequestBody Modulo modulo) {

		String respuesta = imoduloService.actualizarModulo(modulo);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
	
	@PostMapping("/eliminarmodulo")
	public ResponseEntity<String> eliminarModulo(@Valid @RequestBody Modulo modulo) {

		String respuesta = imoduloService.eliminarModulo(modulo);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
	
	
}
