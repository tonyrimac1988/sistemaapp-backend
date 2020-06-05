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
@Table(name = "usuario_area")
public class UsuarioArea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidusuarioarea")
	private Integer nIdUsuarioArea;
	
	@ManyToOne
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarioarea_nidusuarioarea_usuario_nidusuario"))
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "nidarea", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarioarea_nidusuarioarea_area_nidarea"))
	private Area area;
	
	@Column(name = "sobservacion", nullable = false, length = 200)
	private String sObservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	public Integer getnIdUsuarioArea() {
		return nIdUsuarioArea;
	}

	public void setnIdUsuarioArea(Integer nIdUsuarioArea) {
		this.nIdUsuarioArea = nIdUsuarioArea;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getsObservacion() {
		return sObservacion;
	}

	public void setsObservacion(String sObservacion) {
		this.sObservacion = sObservacion;
	}

	public boolean isbActivo() {
		return bActivo;
	}

	public void setbActivo(boolean bActivo) {
		this.bActivo = bActivo;
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
