package com.sist.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.sist.org.modelo.Perfil;
import com.sist.org.service.IPerfilService;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

	private static final Logger log = LoggerFactory.getLogger(PerfilController.class);

	@Autowired
	IPerfilService iperfilService;

	@PostMapping(value = "/insertarperfil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarPerfil(@Valid @RequestBody Perfil perfil) {

		String respuesta = iperfilService.insertarPerfil(perfil);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}

	@GetMapping(value = "/listarperfil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Perfil>> listarPerfil() {
		List<Perfil> listaperfil = iperfilService.listarPerfil();
		return new ResponseEntity<List<Perfil>>(listaperfil, HttpStatus.OK);
	}

	@PostMapping("/actualizarperfil")
	public ResponseEntity<String> actualizarPerfil(@Valid @RequestBody Perfil perfil) {
		String respuesta = iperfilService.actualizarPerfil(perfil);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}

	@PostMapping("/eliminarperfil")
	public ResponseEntity<String> eliminarPerfil(@Valid @RequestBody Perfil perfil) {

		String respuesta = iperfilService.eliminarPerfil(perfil);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}

	@GetMapping(value = "/listarPerfilUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> listarMenuPorUsuario(@PathVariable("id") Integer idusuario) {
		Integer idperfil = iperfilService.listarMenuPorUsuario(idusuario);
		return new ResponseEntity<Integer>(idperfil, HttpStatus.OK);
	}

}
