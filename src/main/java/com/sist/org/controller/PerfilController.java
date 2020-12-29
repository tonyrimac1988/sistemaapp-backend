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

	//private static final Logger log = LoggerFactory.getLogger(PerfilController.class);

	@Autowired
	IPerfilService iperfilService;

	@PostMapping(value = "/insertarperfil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> insertarPerfil(@Valid @RequestBody Perfil perfil) {

		//String respuesta = iperfilService.insertarPerfil(perfil);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iperfilService.insertarPerfil(perfil), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método insertarPerfil -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listarperfil", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Perfil>> listarPerfil() {
		//List<Perfil> listaperfil = iperfilService.listarPerfil();
		//return new ResponseEntity<List<Perfil>>(listaperfil, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<Perfil>>(new RespuestaBase<Perfil>(HttpStatus.OK.toString(), "Respuesta OK", iperfilService.listarPerfil()), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<RespuestaBase<Perfil>>(new RespuestaBase<Perfil>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo listarPerfil -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/actualizarperfil")
	public ResponseEntity<RespuestaBase<Object>> actualizarPerfil(@Valid @RequestBody Perfil perfil) {
		//String respuesta = iperfilService.actualizarPerfil(perfil);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iperfilService.actualizarPerfil(perfil), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método actualizarPerfil -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/eliminarperfil")
	public ResponseEntity<RespuestaBase<Object>> eliminarPerfil(@Valid @RequestBody Perfil perfil) {
		//String respuesta = iperfilService.eliminarPerfil(perfil);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iperfilService.eliminarPerfil(perfil), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método eliminarPerfil -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listarPerfilUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> listarMenuPorUsuario(@PathVariable("id") Integer idusuario) {
		
		try {
 
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), iperfilService.listarMenuPorUsuario(idusuario).toString(), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método eliminarPerfil -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
  
		
	}
	
	
	@PostMapping(value = "/listarPerfilPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Perfil>>> listarPerfilPage(@Validated @RequestBody Pageable pageable) {

		//Page<Perfil> listarPerfil = iperfilService.listarPerfilPage(pageable);
		//return new ResponseEntity<Page<Perfil>>(listarPerfil, HttpStatus.OK);
		try {
			return new ResponseEntity<RespuestaBase<Page<Perfil>>>(new RespuestaBase<Page<Perfil>>(HttpStatus.OK.toString(), "Respuesta OK", Arrays.asList(iperfilService.listarPerfilPage(pageable))), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Page<Perfil>>>( new RespuestaBase<Page<Perfil>>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error el metodo listarPerfilPage -> " + e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
