package com.sist.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.modelo.Menu;
import com.sist.org.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

	@Autowired
	IMenuService iMenuService;
	
		
	@PostMapping(value = "/menuusuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listarMenuPorUsuario(@Validated @RequestBody String usuario) {
 
		List<Menu> listarmenu = iMenuService.listarMenuPorUsuario(usuario);

		return new ResponseEntity<List<Menu>>(listarmenu, HttpStatus.OK);
	}
	
	
}
