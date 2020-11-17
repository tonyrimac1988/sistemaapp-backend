package com.sist.org.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.modelo.Operador;
import com.sist.org.modelo.Page;
import com.sist.org.modelo.Pageable;
import com.sist.org.modelo.Usuario;
import com.sist.org.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	IUsuarioService   iUsuarioService;

	@PostMapping(value = "/listarUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Operador>> listarUsuario(@Validated @RequestBody Pageable pageable) {
 
		Page<Operador> listarOperador = iUsuarioService.listarUsuario(pageable);

		return new ResponseEntity<Page<Operador>>(listarOperador, HttpStatus.OK);
	}
	
}
