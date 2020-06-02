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

import com.sistemaapp.model.Sede;
import com.sistemaapp.service.ISedeService;

@RestController
@RequestMapping("/sede")
public class SedeController {
	
	@Autowired
	private ISedeService service;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarSede(@Valid @RequestBody Sede obj){
		Sede sed = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sed.getIdSede()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sede> modificarSede(@Valid @RequestBody Sede obj){
		Sede sed = service.modificar(obj);
		return new ResponseEntity<Sede>(sed, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sede>> listarSede(){
		List<Sede> lista = service.listar();
		return new ResponseEntity<List<Sede>>(lista, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sede> listarPorId(@PathVariable Integer id){
		Sede sed = service.listarPorId(id);
		return new ResponseEntity<Sede>(sed, HttpStatus.OK);		
	}
	

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarSede(@PathVariable Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Sede>> listarPageable(Pageable pageable){
		
		Page<Sede> sed = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Sede>>(sed, HttpStatus.OK);
	}

}
