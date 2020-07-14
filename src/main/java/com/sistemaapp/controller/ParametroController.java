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

import com.sistemaapp.model.Parametro;
import com.sistemaapp.service.IParametroService;

@RestController
@RequestMapping("/parametros")
public class ParametroController {

	private static final Logger log = LoggerFactory.getLogger(ParametroController.class);

	@Autowired
	private IParametroService service;

	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarParametro(@Valid @RequestBody Parametro obj) {
		Parametro par = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(par.getNidparametro())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Parametro>> listarParametro() {
		List<Parametro> lista = service.listar();
		return new ResponseEntity<List<Parametro>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Parametro> listarPorId(@PathVariable Integer id) {
		Parametro par = service.listarPorId(id);
		return new ResponseEntity<Parametro>(par, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Parametro> modificarParametro(@Valid @RequestBody Parametro obj) {
		Parametro par = service.modificar(obj);
		return new ResponseEntity<Parametro>(par, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarParametro(@PathVariable Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Parametro>> listarPageable(Pageable pageable) {

		Page<Parametro> par = service.listarPageable(pageable);

		return new ResponseEntity<Page<Parametro>>(par, HttpStatus.OK);
	}


	@PostMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE, consumes = "text/plain")
	public ResponseEntity<byte[]> generarReporte(@RequestBody String tipoReporte) {
		byte[] data = null;
		log.info(tipoReporte);
		data = service.generarReporte(tipoReporte);
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
	
}
