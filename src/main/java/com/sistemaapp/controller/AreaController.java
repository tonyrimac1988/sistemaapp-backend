package com.sistemaapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistemaapp.model.Area;
import com.sistemaapp.service.IAreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {
	
	@Autowired
	private IAreaService service;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarArea(@Valid @RequestBody Area obj){
		Area are = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(are.getNIdArea()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Area>> listarArea(){
		List<Area> lista = service.listar();
		return new ResponseEntity<List<Area>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Area> listarPorId(@PathVariable Integer id){
		Area are = service.listarPorId(id);
		return new ResponseEntity<Area>(are, HttpStatus.OK);		
	}
	
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Area> modificarArea(@Valid @RequestBody Area obj){
		Area are = service.modificar(obj);
		return new ResponseEntity<Area>(are, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarArea(@PathVariable Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Area>> listarPageable(Pageable pageable){
		
		Page<Area> are = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Area>>(are, HttpStatus.OK);
	}
	
}
