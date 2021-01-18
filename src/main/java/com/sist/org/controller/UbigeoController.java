package com.sist.org.controller;

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
import com.sist.org.modelo.Ubigeo;
import com.sist.org.service.IUbigeoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/ubigeos")
public class UbigeoController {
	

	
	private static final Logger log = LoggerFactory.getLogger(UbigeoController.class);
	
	@Autowired
	IUbigeoService ibigeoService;
	
	@GetMapping(value = "/listardepartamento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Ubigeo>> listarDepartamento() {

		//
		RespuestaBase<Ubigeo> respuesabase = new RespuestaBase<Ubigeo>();
		try {
			respuesabase.setMensaje( "Respuesta OK");
			respuesabase.setEstado(HttpStatus.OK.toString());
			respuesabase.setData(ibigeoService.listarDepartamento());
			
			return new ResponseEntity<RespuestaBase<Ubigeo>>(respuesabase, HttpStatus.OK);
			
		} catch (Exception e) {
			respuesabase.setMensaje("Hubo un error en el metodo listarDepartamento -> "+e.toString());
			respuesabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuesabase.setData(null);
			
			return new ResponseEntity<RespuestaBase<Ubigeo>>(respuesabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	@PostMapping(value = "/listarprovincia", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Ubigeo>> listarprovincia(@Validated @RequestBody String iddepartamento) {

		//
		log.info("->>>>>>>> "+iddepartamento);
		
		RespuestaBase<Ubigeo> respuesabase = new RespuestaBase<Ubigeo>();
		try {
			respuesabase.setMensaje( "Respuesta OK");
			respuesabase.setEstado(HttpStatus.OK.toString());
			respuesabase.setData(ibigeoService.listarprovincia(iddepartamento));
			
			return new ResponseEntity<RespuestaBase<Ubigeo>>(respuesabase, HttpStatus.OK);
			
		} catch (Exception e) {
			respuesabase.setMensaje("Hubo un error en el metodo listarprovincia -> "+e.toString());
			respuesabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuesabase.setData(null);
			
			return new ResponseEntity<RespuestaBase<Ubigeo>>(respuesabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	@PostMapping(value = "/listardistrito", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Ubigeo>> listardistrito(@Validated @RequestBody String idprovincia) {

		//
		RespuestaBase<Ubigeo> respuesabase = new RespuestaBase<Ubigeo>();
		try {
			respuesabase.setMensaje( "Respuesta OK");
			respuesabase.setEstado(HttpStatus.OK.toString());
			respuesabase.setData(ibigeoService.listardistrito(idprovincia));
			
			return new ResponseEntity<RespuestaBase<Ubigeo>>(respuesabase, HttpStatus.OK);
			
		} catch (Exception e) {
			respuesabase.setMensaje("Hubo un error en el metodo listardistrito -> "+e.toString());
			respuesabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuesabase.setData(null);
			
			return new ResponseEntity<RespuestaBase<Ubigeo>>(respuesabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

}
