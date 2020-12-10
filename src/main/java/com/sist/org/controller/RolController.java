package com.sist.org.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.dto.RespuestaBase;
import com.sist.org.modelo.Rol;
import com.sist.org.service.IRolService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	IRolService irolService;

	@PostMapping(value = "/insertarRol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarRol(@Valid @RequestBody Rol rol) {

		String respuesta = irolService.insertarRol(rol);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}

	@GetMapping(value = "/listarRol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rol>> listarRol() {

		List<Rol> listarol = irolService.listarRol();

		return new ResponseEntity<List<Rol>>(listarol, HttpStatus.OK);
	}

	@PostMapping("/actualizarol")
	public ResponseEntity<String> actualizarRol(@Valid @RequestBody Rol rol) {

		String respuesta = irolService.actualizarRol(rol);

		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}

	@PostMapping("/eliminarol")
	public ResponseEntity<String> eliminarRol(@Valid @RequestBody Rol rol) {

		String respuesta = irolService.eliminarRol(rol);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);

	}

	@GetMapping(value = "/listarRolUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> ListarAreaUsuario(@PathVariable("id") Integer idUsuario) {
		Integer idrolusuario = irolService.ListarAreaUsuario(idUsuario);
		return new ResponseEntity<Integer>(idrolusuario, HttpStatus.OK);
	}

	@PostMapping(value = "/listarRolPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Rol>>> listarRolPage(@Validated @RequestBody Pageable pageable) {

		try {

			//int x = 10 /0;
			return new ResponseEntity<RespuestaBase<Page<Rol>>>(new RespuestaBase<Page<Rol>>(HttpStatus.OK.toString(),
					"Respuesta OK", Arrays.asList(irolService.listarRolPage(pageable))), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<RespuestaBase<Page<Rol>>>(
					new RespuestaBase<Page<Rol>>(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
							"Hubo un error el metodo listarRolPage -> " + e.toString(), null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		

		// Page<Rol> listarRol = irolService.listarRolPage(pageable);

	}

}
