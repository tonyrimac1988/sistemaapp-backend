package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidmenu")
	private Integer nIdMenu;
	
	@Column(name = "snombremenu", nullable = false, length = 100)
	private String sNombreMenu;
	
	@Column(name = "sLogoMenu", nullable = false, length = 50)
	private String sLogoMenu;
	
	@Column(name = "srutamenu", nullable = false, length = 50)
	private String sRutaMenu;
	
	@Column(name = "nidmenupadre", nullable = false)
	private Integer nIdMenuPadre;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@ManyToOne
	@JoinColumn(name = "nidmodulo", nullable = false, foreignKey = @ForeignKey(name = "fk_menu_nidmodulo_modulo_nidmodulo"))
	private Modulo modulo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	public Integer getnIdMenu() {
		return nIdMenu;
	}

	public void setnIdMenu(Integer nIdMenu) {
		this.nIdMenu = nIdMenu;
	}

	public String getsNombreMenu() {
		return sNombreMenu;
	}

	public void setsNombreMenu(String sNombreMenu) {
		this.sNombreMenu = sNombreMenu;
	}

	public String getsLogoMenu() {
		return sLogoMenu;
	}

	public void setsLogoMenu(String sLogoMenu) {
		this.sLogoMenu = sLogoMenu;
	}

	public String getsRutaMenu() {
		return sRutaMenu;
	}

	public void setsRutaMenu(String sRutaMenu) {
		this.sRutaMenu = sRutaMenu;
	}

	public Integer getnIdMenuPadre() {
		return nIdMenuPadre;
	}

	public void setnIdMenuPadre(Integer nIdMenuPadre) {
		this.nIdMenuPadre = nIdMenuPadre;
	}

	public boolean isbActivo() {
		return bActivo;
	}

	public void setbActivo(boolean bActivo) {
		this.bActivo = bActivo;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public LocalDate getdFechaReg() {
		return dFechaReg;
	}

	public void setdFechaReg(LocalDate dFechaReg) {
		this.dFechaReg = dFechaReg;
	}

//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	 
	

}
