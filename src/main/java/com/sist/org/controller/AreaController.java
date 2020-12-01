package com.sist.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.modelo.Area;
import com.sist.org.service.IAreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {
	
 
	
	@Autowired
	IAreaService iareaService;
	
	@PostMapping(value= "/insertararea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarArea(@Valid @RequestBody Area area){

		String respuesta = iareaService.insertarArea(area);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}

	@GetMapping(value = "/listararea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Area>> listarArea() {

		List<Area> listarea = iareaService.listarArea();

		return new ResponseEntity<List<Area>>(listarea, HttpStatus.OK);
	}
	
	@PostMapping("/actualizararea")
	public ResponseEntity<String> actualizarArea(@Valid @RequestBody Area area) {

		String respuesta = iareaService.actualizarArea(area);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping("/eliminararea")
	public ResponseEntity<String> eliminarArea(@Valid @RequestBody Area area) {

		String respuesta = iareaService.eliminarArea(area);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}

	
	@GetMapping(value = "/listarAreaUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> ListarAreaUsuario(@PathVariable("id") Integer idarea) {
		Integer idareausuario = iareaService.ListarAreaUsuario(idarea);
		return new ResponseEntity<Integer>(idareausuario, HttpStatus.OK);
	}
}
