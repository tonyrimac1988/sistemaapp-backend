package com.sist.org.controller;

import java.util.Arrays;

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
import com.sist.org.modelo.Perfil;
import com.sist.org.service.IPerfilService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

 
	@Autowired
	IPerfilService iperfilService;

	@PostMapping(value = "/insertarperfil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> insertarPerfil(@Valid @RequestBody Perfil perfil) {
  
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iperfilService.insertarPerfil(perfil));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo insertarPerfil -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		
	}

	@GetMapping(value = "/listarperfil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Perfil>> listarPerfil() {
 
		
		RespuestaBase<Perfil> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(iperfilService.listarPerfil());

			return new ResponseEntity<RespuestaBase<Perfil>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarPerfil -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Perfil>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		 
	}

	@PostMapping("/actualizarperfil")
	public ResponseEntity<RespuestaBase<Object>> actualizarPerfil(@Valid @RequestBody Perfil perfil) {
	  
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iperfilService.actualizarPerfil(perfil));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo actualizarPerfil -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}

	@PostMapping("/eliminarperfil")
	public ResponseEntity<RespuestaBase<Object>> eliminarPerfil(@Valid @RequestBody Perfil perfil) {
		 
		
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iperfilService.eliminarPerfil(perfil));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo eliminarPerfil -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 
	}

	@GetMapping(value = "/listarPerfilUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> listarMenuPorUsuario(@PathVariable("id") Integer idusuario) {
		
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iperfilService.listarMenuPorUsuario(idusuario).toString());
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarMenuPorUsuario -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
  
	}
	
	
	@PostMapping(value = "/listarPerfilPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Perfil>>> listarPerfilPage(@Validated @RequestBody Pageable pageable) {
 
		RespuestaBase<Page<Perfil>> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(iperfilService.listarPerfilPage(pageable)));

			return new ResponseEntity<RespuestaBase<Page<Perfil>>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarPerfilPage -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Page<Perfil>>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 
	}

}
