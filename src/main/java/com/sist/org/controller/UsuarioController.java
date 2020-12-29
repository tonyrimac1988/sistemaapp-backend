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

		//Page<Operador> listarOperador = iUsuarioService.listarUsuario(pageable);
		//return new ResponseEntity<Page<Operador>>(listarOperador, HttpStatus.OK);
		try {
			return new ResponseEntity<RespuestaBase<Page<Operador>>>(new RespuestaBase<Page<Operador>>(HttpStatus.OK.toString(), "Respuesta OK", Arrays.asList(iUsuarioService.listarUsuario(pageable))), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Page<Operador>>>( new RespuestaBase<Page<Operador>>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error el metodo listarUsuario -> " + e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	@PostMapping(value = "/consultaUsuariosesion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<UsuarioSesion>> ConsultaUsuariosesion(@Validated @RequestBody String usuario) {

		//UsuarioSesion usuarioSesion = iUsuarioService.ConsultaUsuariosesion(usuario);
		//return new ResponseEntity<UsuarioSesion>(usuarioSesion, HttpStatus.OK);
		try {
			
			return new ResponseEntity<RespuestaBase<UsuarioSesion>>(new RespuestaBase<UsuarioSesion>(HttpStatus.OK.toString(), "Respuesta OK", Arrays.asList(iUsuarioService.ConsultaUsuariosesion(usuario))), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<RespuestaBase<UsuarioSesion>>(new RespuestaBase<UsuarioSesion>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el meotodo listarArea -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/modificarUsuarioOperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> modificarUsuarioOperador(@Validated @RequestBody OperadorDto operadorDto) {
 
		//RespuestaBase<Object> respuestabase = new RespuestaBase<>() ;
	 
		try {
			
			String respuesta = iUsuarioService.modificarUsuarioOperador(operadorDto);
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), respuesta, null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el método insertarArea -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
