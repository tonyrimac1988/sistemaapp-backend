package com.sist.org.controller;
import java.util.Arrays;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.dto.OperadorDto;
import com.sist.org.dto.RespuestaBase;
import com.sist.org.service.IOperadorService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@RestController
@RequestMapping("/operadores")
public class OperadorController {


	
	private static final Logger log = LoggerFactory.getLogger(OperadorController.class);
	
	
	@Autowired
	IOperadorService iOperadorService;

	@PostMapping(value = "/listaroperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<OperadorDto>>> listarOperador(@Validated @RequestBody Pageable pageable) {
		
		RespuestaBase<Page<OperadorDto>> respuesabase= new RespuestaBase<>();
		try {
			respuesabase.setEstado(HttpStatus.OK.toString());
			respuesabase.setMensaje("Respuesta OK");
			respuesabase.setData(Arrays.asList(iOperadorService.listarOperador(pageable)));
			return new ResponseEntity<RespuestaBase<Page<OperadorDto>>>( respuesabase, HttpStatus.OK);

		} catch (Exception e) {
			
			respuesabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuesabase.setMensaje("Hubo un error el metodo listarUsuario -> " + e.toString());
			respuesabase.setData(null);
			return new ResponseEntity<RespuestaBase<Page<OperadorDto>>>( respuesabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
 
	
	@PostMapping("/eliminaroperador")
	public ResponseEntity<RespuestaBase<Object>> EliminarOperador(@Valid @RequestBody int operador) {

		log.info("operador - > "+operador);
		//operador.setNidoperador(2);
		
		//String respuesta = iPersonaService.eliminarOperador(operador);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iOperadorService.eliminarOperador(operador), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo eliminarOperador -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/modificarUsuarioOperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> modificarUsuarioOperador(@Validated @RequestBody OperadorDto operadorDto) {
 
		log.info(operadorDto.toString());
		
		RespuestaBase<Object> respuestabase = new RespuestaBase<>() ;
	 
		try {
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iOperadorService.modificarUsuarioOperador(operadorDto));
			 
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
			
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el método modificarUsuarioOperador -> "+e.toString());
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value= "/insertaroperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> InsertarOperador(@Valid @RequestBody OperadorDto operador) {

		//String respuesta = iPersonaService.insertarOperador(operador);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		log.info(operador.toString());
		
		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iOperadorService.insertarOperador(operador), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método insertarOperador -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
