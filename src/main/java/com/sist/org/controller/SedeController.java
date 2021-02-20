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
import com.sist.org.dto.SedeDTO;
import com.sist.org.service.ISedeService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@RestController
@RequestMapping("/sedes")
public class SedeController {
	
	@Autowired
	ISedeService isedeService;
	
	@PostMapping(value= "/insertarsede", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> insertarSede(@Valid @RequestBody SedeDTO sede){


		RespuestaBase<Object> respuestabase = new RespuestaBase<>();		
		try {
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(isedeService.insertarSede(sede));
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
			
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el meotodo insertarArea -> "+e.toString());
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listarsede", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<SedeDTO>> listarSede() {
 
		
		RespuestaBase<SedeDTO> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(isedeService.listarSede());

			return new ResponseEntity<RespuestaBase<SedeDTO>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarSede -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<SedeDTO>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 
	}
	
	@PostMapping("/actualizarsede")
	public ResponseEntity<RespuestaBase<Object>> actualizarSede(@Valid @RequestBody SedeDTO sede) {


		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(isedeService.actualizarSede(sede));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo actualizarSede -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
		
	}
	
	@PostMapping("/eliminarsede")
	public ResponseEntity<RespuestaBase<Object>> eliminarSede(@Valid @RequestBody SedeDTO sede) {
 
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(isedeService.eliminarSede(sede));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo eliminarSede -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 

	}
	
	@PostMapping(value = "/listarSedePage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<SedeDTO>>> listarSedePage(@Validated @RequestBody Pageable pageable) {

		RespuestaBase<Page<SedeDTO>> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(isedeService.listarSedePage(pageable)));

			return new ResponseEntity<RespuestaBase<Page<SedeDTO>>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarSedePage -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Page<SedeDTO>>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}

}
