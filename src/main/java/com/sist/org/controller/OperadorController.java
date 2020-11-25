package com.sist.org.controller;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.modelo.Operador;
import com.sist.org.service.IOperadorService;

@RestController
@RequestMapping("/operador")
public class OperadorController {


	
	private static final Logger log = LoggerFactory.getLogger(OperadorController.class);
	
	
	@Autowired
	IOperadorService iPersonaService;

	@GetMapping(value = "/listaroperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Operador>> listarOperador() {

		List<Operador> listaoperador = iPersonaService.listarOperador();

		return new ResponseEntity<List<Operador>>(listaoperador, HttpStatus.OK);

	}
	
	@PostMapping("/eliminaroperador")
	public ResponseEntity<String> EliminarOperador(@Valid @RequestBody Operador operador) {

		log.info("operador - > "+operador);
		//operador.setNidoperador(2);
		
		String respuesta = iPersonaService.eliminarOperador(operador);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
	
	@PostMapping("/actualizaroperador")
	public ResponseEntity<String> ActualizarOperador(@Valid @RequestBody Operador operador) {

		String respuesta = iPersonaService.actualizarOperador(operador);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
	
	@PostMapping(value= "/insertaroperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> InsertarOperador(@Valid @RequestBody Operador operador) {

		String respuesta = iPersonaService.insertarOperador(operador);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}
}
