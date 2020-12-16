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

		//String respuesta = iareaService.insertarArea(area);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {
			
			String respuesta = iareaService.insertarArea(area);
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), respuesta, null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo insertarArea -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	@GetMapping(value = "/listararea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Area>> listarArea() {

		//List<Area> listarea = iareaService.listarArea();
		//return new ResponseEntity<List<Area>>(listarea, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Area>>(new RespuestaBase<Area>(HttpStatus.OK.toString(), "Respuesta OK", iareaService.listarArea()), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<RespuestaBase<Area>>(new RespuestaBase<Area>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo listarArea -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@PostMapping("/actualizararea")
	public ResponseEntity<RespuestaBase<Object>> actualizarArea(@Valid @RequestBody Area area) {

		//String respuesta = iareaService.actualizarArea(area);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {
			
			String respuesta = iareaService.actualizarArea(area);
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), respuesta, null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo actualizarArea -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/eliminararea")
	public ResponseEntity<RespuestaBase<Object>> eliminarArea(@Valid @RequestBody Area area) {

		//String respuesta = iareaService.eliminarArea(area);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iareaService.eliminarArea(area), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo eliminarArea -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping(value = "/listarAreaUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> ListarAreaUsuario(@PathVariable("id") Integer idarea) {
		Integer idareausuario = iareaService.ListarAreaUsuario(idarea);
		return new ResponseEntity<Integer>(idareausuario, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/listarAreaPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Area>>> listarAreaPage(@Validated @RequestBody Pageable pageable) {

		//Page<Area> listarArea = iareaService.listarAreaPage(pageable);
		//return new ResponseEntity<Page<Area>>(listarArea, HttpStatus.OK);
		try {
			return new ResponseEntity<RespuestaBase<Page<Area>>>(new RespuestaBase<Page<Area>>(HttpStatus.OK.toString(), "Respuesta OK", Arrays.asList(iareaService.listarAreaPage(pageable))), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Page<Area>>>( new RespuestaBase<Page<Area>>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error el metodo listarRolPage -> " + e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
