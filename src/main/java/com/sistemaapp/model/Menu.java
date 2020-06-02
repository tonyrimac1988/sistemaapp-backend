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
@Table(name = "menú")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMenu;
	
	@Column(name = "des_menu", nullable = false, length = 100)
	private String desMenu;
	
	@Column(name = "tag_menu", nullable = false, length = 15)
	private String tagMenu;
	
	@Column(name = "tipo_menu", nullable = false, length = 50)
	private String tipoMenu;
	
	@Column(name = "id_menu_padre", nullable = false)
	private Integer idMenuPadre;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
	
	@ManyToOne
	@JoinColumn(name = "id_modulo", nullable = false, foreignKey = @ForeignKey(name = "id_menu_modulo"))
	private Modulo modulo;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;

//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	
	
	public Integer getIdMenu() {
		return idMenu;
	}
	
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getDesMenu() {
		return desMenu;
	}

	public void setDesMenu(String desMenu) {
		this.desMenu = desMenu;
	}

	public String getTagMenu() {
		return tagMenu;
	}

	public void setTagMenu(String tagMenu) {
		this.tagMenu = tagMenu;
	}

	public String getTipoMenu() {
		return tipoMenu;
	}

	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	public Integer getIdMenuPadre() {
		return idMenuPadre;
	}

	public void setIdMenuPadre(Integer idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
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

	public LocalDate getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}
	

}
