package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "menu_rol")
@IdClass(MenuRolPK.class)
public class MenuRol {
	
	@Id
	private Rol rol;
	
	@Id
	private Menu menu;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dfechaReg;
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion idSesion;

}
