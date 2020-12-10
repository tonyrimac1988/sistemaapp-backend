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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	IUsuarioService iUsuarioService;

	
	@PostMapping(value = "/listarUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Operador>> listarUsuario(@Validated @RequestBody Pageable pageable) {

		Page<Operador> listarOperador = iUsuarioService.listarUsuario(pageable);

		return new ResponseEntity<Page<Operador>>(listarOperador, HttpStatus.OK);
	}

	@PostMapping(value = "/consultaUsuariosesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioSesion> ConsultaUsuariosesion(@Validated @RequestBody String usuario) {

		UsuarioSesion usuarioSesion = iUsuarioService.ConsultaUsuariosesion(usuario);

		return new ResponseEntity<UsuarioSesion>(usuarioSesion, HttpStatus.OK);
	}

//	@PostMapping(value = "/modificarUsuarioOperador", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<RespuestaBase<Object>> modificarUsuarioOperador(@Validated @RequestBody OperadorDto operadorDto) {
// 
//		RespuestaBase<Object> respuestabase = new RespuestaBase<>() ;
//		String respuesta = iUsuarioService.modificarUsuarioOperador(operadorDto);
//		respuestabase.setMensaje(respuesta);
//		return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
//	}

}
