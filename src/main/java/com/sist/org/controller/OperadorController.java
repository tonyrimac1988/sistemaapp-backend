package com.sist.org.controller;
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

import com.sist.org.dto.RespuestaBase;
import com.sist.org.modelo.Operador;
import com.sist.org.service.IOperadorService;

@RestController
@RequestMapping("/operadores")
public class OperadorController {


	
	private static final Logger log = LoggerFactory.getLogger(OperadorController.class);
	
	
	@Autowired
	IOperadorService iPersonaService;

	@GetMapping(value = "/listaroperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Operador>> listarOperador() {

		//List<Operador> listaoperador = iPersonaService.listarOperador();
		//return new ResponseEntity<List<Operador>>(listaoperador, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Operador>>(new RespuestaBase<Operador>(HttpStatus.OK.toString(), "Respuesta OK", iPersonaService.listarOperador()), HttpStatus.OK);		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<RespuestaBase<Operador>>(new RespuestaBase<Operador>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo listarOperador -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/eliminaroperador")
	public ResponseEntity<RespuestaBase<Object>> EliminarOperador(@Valid @RequestBody Operador operador) {

		log.info("operador - > "+operador);
		//operador.setNidoperador(2);
		
		//String respuesta = iPersonaService.eliminarOperador(operador);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iPersonaService.eliminarOperador(operador), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo eliminarOperador -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/actualizaroperador")
	public ResponseEntity<RespuestaBase<Object>> ActualizarOperador(@Valid @RequestBody Operador operador) {

		//String respuesta = iPersonaService.actualizarOperador(operador);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iPersonaService.actualizarOperador(operador), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método actualizarOperador -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value= "/insertaroperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> InsertarOperador(@Valid @RequestBody Operador operador) {

		//String respuesta = iPersonaService.insertarOperador(operador);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iPersonaService.insertarOperador(operador), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método insertarOperador -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
