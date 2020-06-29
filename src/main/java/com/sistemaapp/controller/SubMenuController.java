package com.sistemaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaapp.service.ISubMenuService;

@RestController
@RequestMapping("/submenu")
public class SubMenuController {

	
	@Autowired
	private ISubMenuService service;
	
	
	
}
