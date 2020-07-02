package com.sistemaapp.controller;

import java.net.URI;
import java.util.ArrayList;
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

import com.sistemaapp.model.Menu;
import com.sistemaapp.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

	private static final Logger log = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private IMenuService service;

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarMenu(@Valid @RequestBody Menu obj) {
		Menu men = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(men.getNIdMenu())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listarMenu() {
		
		List<Menu> lista = service.listar();
  
		return new ResponseEntity<List<Menu>>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Menu> listarPorId(@PathVariable Integer id) {
		Menu men = service.listarPorId(id);
		return new ResponseEntity<Menu>(men, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarnombre/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listarPorNombre(@PathVariable String key) {
		List<Menu> lista = service.listarMenuPorNombreMenu(key);
		return new ResponseEntity<List<Menu>>(lista, HttpStatus.OK);
	}
	

	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Menu> modificarMenu(@Valid @RequestBody Menu obj) {
		Menu men = service.modificar(obj);
		return new ResponseEntity<Menu>(men, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarMenu(@PathVariable Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Menu>> listarPageable(Pageable pageable) {

		Page<Menu> men = service.listarPageable(pageable);

		return new ResponseEntity<Page<Menu>>(men, HttpStatus.OK);
	}

	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String nombre) {

		log.info(nombre);

		List<Menu> menus = new ArrayList<>();
		menus = service.listarMenuPorUsuario(nombre);

		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}

	@PostMapping(value = "/generarReporteExcel", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE, consumes = "application/json")
	public ResponseEntity<byte[]> generarReporte() {
		byte[] data = null;
		data = service.generarReporte();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
	
	 
	
}
