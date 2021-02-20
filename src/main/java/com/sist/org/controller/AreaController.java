package com.sist.org.controller;

import java.util.Arrays;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.dto.RespuestaBase;
import com.sist.org.modelo.Area;
import com.sist.org.service.IAreaService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@RestController
@RequestMapping("/areas")
public class AreaController {
	
 
	
	@Autowired
	IAreaService iareaService;
	
	@PostMapping(value= "/insertararea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> insertarArea(@Valid @RequestBody Area area){


		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iareaService.insertarArea(area));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo insertarArea -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 
	}

	@GetMapping(value = "/listararea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Area>> listarArea() {
		
		RespuestaBase<Area> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(iareaService.listarArea());

			return new ResponseEntity<RespuestaBase<Area>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarArea -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Area>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 	
	}
	
	@PostMapping("/actualizararea")
	public ResponseEntity<RespuestaBase<Object>> actualizarArea(@Valid @RequestBody Area area) {

		
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iareaService.actualizarArea(area));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo actualizarArea -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}
	
	@PostMapping("/eliminararea")
	public ResponseEntity<RespuestaBase<Object>> eliminarArea(@Valid @RequestBody Area area) {
 
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iareaService.eliminarArea(area));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo eliminarArea -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
		 
	}

	
	@GetMapping(value = "/listarAreaUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> ListarAreaUsuario(@PathVariable("id") Integer idarea) {

		
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iareaService.ListarAreaUsuario(idarea).toString());
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo ListarAreaUsuario -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 
	}
	
	
	@PostMapping(value = "/listarAreaPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Area>>> listarAreaPage(@Validated @RequestBody Pageable pageable) {


		RespuestaBase<Page<Area>> respuestabase = new RespuestaBase<>();
		
		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(iareaService.listarAreaPage(pageable)));
		
			return new ResponseEntity<RespuestaBase<Page<Area>>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
		
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarAreaPage -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Page<Area>>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 
	}
}
