package com.sist.org.controller;
import java.util.Arrays;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.dto.RespuestaBase;
import com.sist.org.modelo.Sede;
import com.sist.org.service.ISedeService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@RestController
@RequestMapping("/sedes")
public class SedeController {
	
	@Autowired
	ISedeService isedeService;
	
	@PostMapping(value= "/insertarsede", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> insertarSede(@Valid @RequestBody Sede sede){

		//String respuesta = isedeService.insertarSede(sede);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(),isedeService.insertarSede(sede), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo insertarArea -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listarsede", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Sede>> listarSede() {

		//List<Sede> listasede = isedeService.listarSede();
		//return new ResponseEntity<List<Sede>>(listasede, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Sede>>(new RespuestaBase<Sede>(HttpStatus.OK.toString(), "Respuesta OK", isedeService.listarSede()), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<RespuestaBase<Sede>>(new RespuestaBase<Sede>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo listarSede -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/actualizarsede")
	public ResponseEntity<RespuestaBase<Object>> actualizarSede(@Valid @RequestBody Sede sede) {

		//String respuesta = isedeService.actualizarSede(sede);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(),isedeService.actualizarSede(sede), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo actualizarSede -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/eliminarsede")
	public ResponseEntity<RespuestaBase<Object>> eliminarSede(@Valid @RequestBody Sede sede) {

		//String respuesta = isedeService.eliminarSede(sede);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), isedeService.eliminarSede(sede), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo eliminarSede -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping(value = "/listarSedePage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Sede>>> listarSedePage(@Validated @RequestBody Pageable pageable) {

		//Page<Sede> listarSede = isedeService.listarSedePage(pageable);
		//return new ResponseEntity<Page<Sede>>(listarSede, HttpStatus.OK);
		try {
			return new ResponseEntity<RespuestaBase<Page<Sede>>>(new RespuestaBase<Page<Sede>>(HttpStatus.OK.toString(), "Respuesta OK", Arrays.asList(isedeService.listarSedePage(pageable))), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Page<Sede>>>( new RespuestaBase<Page<Sede>>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error el metodo listarRolPage -> " + e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
