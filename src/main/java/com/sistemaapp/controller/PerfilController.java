package com.sistemaapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.sistemaapp.model.Perfil;
import com.sistemaapp.service.IPerfilService;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {
	
	private static final Logger log = LoggerFactory.getLogger(PerfilController.class);
	
	@Autowired
	private IPerfilService service;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarPerfil(@Valid @RequestBody Perfil obj){
		Perfil per = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(per.getNidperfil()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Perfil>> listarPerfil(){
		List<Perfil> lista = service.listar();
		return new ResponseEntity<List<Perfil>>(lista, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil> listarPorId(@PathVariable Integer id){
		Perfil per = service.listarPorId(id);
		return new ResponseEntity<Perfil>(per, HttpStatus.OK);		
	}
	
	
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil> modificarPerfil(@Valid @RequestBody Perfil obj){
		Perfil per = service.modificar(obj);
		return new ResponseEntity<Perfil>(per, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarPerfil(@PathVariable Integer id){
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Perfil>> listarPageable(Pageable pageable){
		
		Page<Perfil> per = service.listarPageable(pageable);
		
		return new ResponseEntity<Page<Perfil>>(per, HttpStatus.OK);
	}
	
	@PostMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE, consumes = "text/plain")
	public ResponseEntity<byte[]> generarReporte(@RequestBody String tipoReporte) {
		byte[] data = null;
		log.info(tipoReporte);
		data = service.generarReporte(tipoReporte);
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

}
