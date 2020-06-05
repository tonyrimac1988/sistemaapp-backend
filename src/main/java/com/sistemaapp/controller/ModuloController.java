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

import com.sistemaapp.model.Modulo;
import com.sistemaapp.service.IModuloService;

@RestController
@RequestMapping("/modulo")
public class ModuloController {
	
	@Autowired
	private IModuloService service;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarModulo(@Valid @RequestBody Modulo obj){
		Modulo mod = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mod.getnIdModulo()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Modulo>> listarModulo(){
		List<Modulo> lista = service.listar();
		return new ResponseEntity<List<Modulo>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modulo> listarPorId(@PathVariable Integer id){
		Modulo mod = service.listarPorId(id);
		return new ResponseEntity<Modulo>(mod, HttpStatus.OK);		
	}
	
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modulo> modificarModulo(@Valid @RequestBody Modulo obj){
		Modulo mod = service.modificar(obj);
		return new ResponseEntity<Modulo>(mod, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarModulo(@PathVariable Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Modulo>> listarPageable(Pageable pageable){
		
		Page<Modulo> mod = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Modulo>>(mod, HttpStatus.OK);
	}

}
