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

import com.sistemaapp.model.Rol;
import com.sistemaapp.service.IRolService;


@RestController
@RequestMapping("/roles")
public class RolController {
	
	@Autowired
	private IRolService service;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarRol(@Valid @RequestBody Rol obj){
		Rol rol = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rol.getNIdRol()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rol>> listarRol(){
		List<Rol> lista = service.listar();
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rol> listarPorId(@PathVariable Integer id){
		Rol rol = service.listarPorId(id);
		return new ResponseEntity<Rol>(rol, HttpStatus.OK);		
	}
	
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rol> modificarRol(@Valid @RequestBody Rol obj){
		Rol rol = service.modificar(obj);
		return new ResponseEntity<Rol>(rol, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarRol(@PathVariable Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Rol>> listarPageable(Pageable pageable){
		
		Page<Rol> rol = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Rol>>(rol, HttpStatus.OK);
	}

}
