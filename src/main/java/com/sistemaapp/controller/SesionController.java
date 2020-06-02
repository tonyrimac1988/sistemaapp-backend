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

import com.sistemaapp.model.Sesion;
import com.sistemaapp.service.ISesionService;

@RestController
@RequestMapping("/sesion")
public class SesionController {
	
	@Autowired
	private ISesionService service;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarSesion(@Valid @RequestBody Sesion obj){
		Sesion ses = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ses.getIdSesion()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sesion>> listarSesion(){
		List<Sesion> lista = service.listar();
		return new ResponseEntity<List<Sesion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sesion> listarPorId(@PathVariable Integer id){
		Sesion ses = service.listarPorId(id);
		return new ResponseEntity<Sesion>(ses, HttpStatus.OK);		
	}
	
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sesion> modificarSesion(@Valid @RequestBody Sesion obj){
		Sesion ses = service.modificar(obj);
		return new ResponseEntity<Sesion>(ses, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarSesion(@PathVariable Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	

	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Sesion>> listarPageable(Pageable pageable){
		
		Page<Sesion> ses = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Sesion>>(ses, HttpStatus.OK);
	}
	
}
