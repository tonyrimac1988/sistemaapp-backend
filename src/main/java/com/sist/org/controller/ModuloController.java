package com.sist.org.controller;
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

import com.sist.org.dto.RespuestaBase;
import com.sist.org.modelo.Modulo;
import com.sist.org.service.IModuloService;

@RestController
@RequestMapping("/modulos")
public class ModuloController {

	@Autowired
	IModuloService imoduloService;
	
	@PostMapping(value= "/insertarmodulo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> insertarModulo(@Valid @RequestBody Modulo modulo){

		//String respuesta = imoduloService.insertarModulo(modulo);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), imoduloService.insertarModulo(modulo), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo imoduloService -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listarmodulo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Modulo>> listarModulo() {

		//List<Modulo> listamodulo = imoduloService.listarModulo();
		//return new ResponseEntity<List<Modulo>>(listamodulo, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Modulo>>(new RespuestaBase<Modulo>(HttpStatus.OK.toString(), "Respuesta OK", imoduloService.listarModulo()), HttpStatus.OK);			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<RespuestaBase<Modulo>>(new RespuestaBase<Modulo>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo listarModulo -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/actualizarmodulo")
	public ResponseEntity<RespuestaBase<Object>> actualizarModulo(@Valid @RequestBody Modulo modulo) {

		//String respuesta = imoduloService.actualizarModulo(modulo);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), imoduloService.actualizarModulo(modulo), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo actualizarModulo -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/eliminarmodulo")
	public ResponseEntity<RespuestaBase<Object>> eliminarModulo(@Valid @RequestBody Modulo modulo) {

		//String respuesta = imoduloService.eliminarModulo(modulo);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), imoduloService.eliminarModulo(modulo), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo eliminarModulo -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
