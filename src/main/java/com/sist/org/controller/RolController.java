package com.sist.org.controller;

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
import com.sist.org.modelo.RolProcedimiento;
import com.sist.org.service.IRolService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	IRolService irolService;

	@PostMapping(value = "/insertarRol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> insertarRol(@Valid @RequestBody Rol rol) {
 
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(irolService.insertarRol(rol));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo insertarRol -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 	 		
	}

	@GetMapping(value = "/listarRol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Rol>> listarRol() {


		RespuestaBase<Rol> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(irolService.listarRol());

			return new ResponseEntity<RespuestaBase<Rol>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarRol -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Rol>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}

	@PostMapping("/actualizarol")
	public ResponseEntity<RespuestaBase<Object>> actualizarRol(@Valid @RequestBody Rol rol) {
 
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(irolService.actualizarRol(rol));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo actualizarRol -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}

	@PostMapping("/eliminarol")
	public ResponseEntity<RespuestaBase<Object>> eliminarRol(@Valid @RequestBody Rol rol) {


		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(irolService.eliminarRol(rol));
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo eliminarRol -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		 
	}

	@GetMapping(value = "/listarRolUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> ListarAreaUsuario(@PathVariable("id") Integer idUsuario) {
		   
		RespuestaBase<Object> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(irolService.ListarAreaUsuario(idUsuario).toString());
			respuestabase.setData(null);

			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo ListarAreaUsuario -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
		
	}

	@PostMapping(value = "/listarRolPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Rol>>> listarRolPage(@Validated @RequestBody Pageable pageable) {
	
		
		RespuestaBase<Page<Rol>> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(irolService.listarRolPage(pageable)));

			return new ResponseEntity<RespuestaBase<Page<Rol>>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarRolPage -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Page<Rol>>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}
	
	
	@PostMapping("/registrarrolprocedimiento")
	public ResponseEntity<RespuestaBase<Object>> registrarrolprocedimiento(@Valid @RequestBody RolProcedimiento rolprocedimiento) {

		RespuestaBase<Object> respuestabase = new RespuestaBase<>();
		 
		try {
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(irolService.registrarrolprocedimiento(rolprocedimiento));
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
			
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo registrarrolprocedimiento -> "+e.toString());
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	
	@PostMapping("/registrarrolprocedimientolista")
	public ResponseEntity<RespuestaBase<Object>> registrarrolprocedimientolista(@Valid @RequestBody List<RolProcedimiento> listarolprocedimiento) {

		RespuestaBase<Object> respuestabase = new RespuestaBase<>();
		 
		try {
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(irolService.registrarrolprocedimientoLista(listarolprocedimiento));
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
			
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo registrarrolprocedimientolista -> "+e.toString());
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	
	
	

}
