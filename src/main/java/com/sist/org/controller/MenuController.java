package com.sist.org.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.dto.RespuestaBase;
import com.sist.org.dto.RolMenuDTO;
import com.sist.org.modelo.Menu;
import com.sist.org.modelo.Procedimiento;
import com.sist.org.service.IMenuService;
	
@RestController
@RequestMapping("/menus")
public class MenuController {

	private static final Logger log = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	IMenuService iMenuService;
	
		
	@PostMapping(value = "/menuusuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Menu>> listarMenuPorUsuario(@Validated @RequestBody String usuario) {
 
		RespuestaBase<Menu> respuestabase = new RespuestaBase<>();

		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(iMenuService.listarMenuPorUsuario(usuario));

			return new ResponseEntity<RespuestaBase<Menu>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo listarMenuPorUsuario -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<Menu>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		 
	}
	
	
	@GetMapping(value = "/listarmenusubmenu", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Menu>> listarmenusubmenu() {
  
		RespuestaBase<Menu> respuestaBase = new RespuestaBase<>();
		
		try {		
			respuestaBase.setData(iMenuService.listarmenusubmenu());
			respuestaBase.setEstado(HttpStatus.OK.toString());
			respuestaBase.setMensaje("Respuesta OK");
						
			return new ResponseEntity<RespuestaBase<Menu>>(respuestaBase, HttpStatus.OK);			
		} catch (Exception e) {
			// TODO: handle exception
			respuestaBase.setData(null);
			respuestaBase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestaBase.setMensaje("Hubo un error en el meotodo listarmenusubmenu -> "+e.toString());
			
			return new ResponseEntity<RespuestaBase<Menu>>(respuestaBase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping(value = "/consultapermisomenu", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Menu>> consultapermisomenu(@Validated @RequestBody RolMenuDTO rolmeu) {
		
		RespuestaBase<Menu> respuestabase = new RespuestaBase<>();
		
		try {			
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje( "Respuesta OK");
			respuestabase.setData(iMenuService.consultapermisomenu(rolmeu));
			
			return new ResponseEntity<RespuestaBase<Menu>>(respuestabase, HttpStatus.OK);			
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje( "Hubo un error en el meotodo listarMenuPorUsuario -> "+e.toString());
			respuestabase.setData(null);			
			return new ResponseEntity<RespuestaBase<Menu>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@PostMapping(value = "/validarpermisosrolmenu", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Procedimiento>> validarpermisosrolmenu(@Validated @RequestBody RolMenuDTO rolmeu) {
		
		RespuestaBase<Procedimiento> respuestabase = new RespuestaBase<>();
		
		try {			
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje( "Respuesta OK");
			respuestabase.setData(iMenuService.validarpermisosrolmenu(rolmeu));
			
			return new ResponseEntity<RespuestaBase<Procedimiento>>(respuestabase, HttpStatus.OK);			
		} catch (Exception e) {

			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje( "Hubo un error en el meotodo validar permisos rol menu -> "+e.toString());
			respuestabase.setData(null);			
			return new ResponseEntity<RespuestaBase<Procedimiento>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  

	}
	
}
