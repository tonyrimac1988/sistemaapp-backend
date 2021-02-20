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

import com.sist.org.dto.OperadorDto;
import com.sist.org.dto.RespuestaBase;
import com.sist.org.dto.UsuarioSesion;
import com.sist.org.modelo.Operador;
import com.sist.org.service.IUsuarioService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	IUsuarioService iUsuarioService;

	
	@PostMapping(value = "/listarUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Operador>>> listarUsuario(@Validated @RequestBody Pageable pageable) {

		RespuestaBase<Page<Operador>> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(iUsuarioService.listarUsuario(pageable)));

			return new ResponseEntity<RespuestaBase<Page<Operador>>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarUsuario -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Page<Operador>>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
  		
	}

	@PostMapping(value = "/consultaUsuariosesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<UsuarioSesion>> ConsultaUsuariosesion(@Validated @RequestBody String usuario) {
 
		RespuestaBase<UsuarioSesion> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(iUsuarioService.ConsultaUsuariosesion(usuario)));

			return new ResponseEntity<RespuestaBase<UsuarioSesion>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo ConsultaUsuariosesion -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<UsuarioSesion>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}

	@PostMapping(value = "/modificarUsuarioOperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> modificarUsuarioOperador(@Validated @RequestBody OperadorDto operadorDto) {
 
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iUsuarioService.modificarUsuarioOperador(operadorDto));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo modificarUsuarioOperador -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		 
	}

}
