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
	public ResponseEntity<RespuestaBase<Object>> insertarRol(@Valid @RequestBody Rol rol) {

		try {
		
			String respuesta = irolService.insertarRol(rol);
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), respuesta, null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo insertarRol -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}		 		
	}

	@GetMapping(value = "/listarRol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Rol>> listarRol() {

		//List<Rol> listarol = irolService.listarRol();
		//return new ResponseEntity<List<Rol>>(listarol, HttpStatus.OK);
				
		try {
			
//			List<Rol> listarol = irolService.listarRol();
//			String respuesta = "Respuesta OK"; 
			
			return new ResponseEntity<RespuestaBase<Rol>>(new RespuestaBase<Rol>(HttpStatus.OK.toString(), "Respuesta OK", irolService.listarRol()), HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<RespuestaBase<Rol>>(new RespuestaBase<Rol>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo listarRol -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/actualizarol")
	public ResponseEntity<RespuestaBase<Object>> actualizarRol(@Valid @RequestBody Rol rol) {

		try {
			
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), irolService.actualizarRol(rol), null), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo actualizarRol -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//String respuesta = irolService.actualizarRol(rol);
		// return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}

	@PostMapping("/eliminarol")
	public ResponseEntity<RespuestaBase<Object>> eliminarRol(@Valid @RequestBody Rol rol) {

		//String respuesta = irolService.eliminarRol(rol);
		//return new ResponseEntity<String>(respuesta, HttpStatus.OK);
		try {

			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.OK.toString(), irolService.eliminarRol(rol), null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<RespuestaBase<Object>>(new RespuestaBase<Object>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error en el metodo eliminarRol -> "+e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listarRolUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> ListarAreaUsuario(@PathVariable("id") Integer idUsuario) {
		Integer idrolusuario = irolService.ListarAreaUsuario(idUsuario);
		return new ResponseEntity<Integer>(idrolusuario, HttpStatus.OK);
	}

	@PostMapping(value = "/listarRolPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<Rol>>> listarRolPage(@Validated @RequestBody Pageable pageable) {
	
		//RespuestaBase<Page<Rol>> respuesta = new RespuestaBase<>();
		
		try {

			//int x = 10 /0;
					
//			respuesta.setEstado(HttpStatus.OK.toString());
//			respuesta.setMensaje("Respuesta OK");
//			respuesta.setData( Arrays.asList(irolService.listarRolPage(pageable)));			
						
//			new RespuestaBase<Page<Rol>>(HttpStatus.OK.toString() ,  "Respuesta OK" , Arrays.asList(irolService.listarRolPage(pageable)) );
//			
//			return new ResponseEntity<RespuestaBase<Page<Rol>>>(respuesta, HttpStatus.OK);
			
			return new ResponseEntity<RespuestaBase<Page<Rol>>>(new RespuestaBase<Page<Rol>>(HttpStatus.OK.toString(), "Respuesta OK", Arrays.asList(irolService.listarRolPage(pageable))), HttpStatus.OK);

		} catch (Exception e) {

//			respuesta.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
//			respuesta.setMensaje("Hubo un error el metodo listarRolPage -> " + e.toString());
//			respuesta.setData(null);		
//			
//			return new ResponseEntity<RespuestaBase<Page<Rol>>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
			
			return new ResponseEntity<RespuestaBase<Page<Rol>>>( new RespuestaBase<Page<Rol>>(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Hubo un error el metodo listarRolPage -> " + e.toString(), null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
	}

}
