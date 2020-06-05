package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidrol")
	private Integer nIdRol;

	@Column(name = "snombrerol", nullable = false, length = 100)
	private String sNombreRol;
	
	@Column(name = "siglas", nullable = false, length = 20)
	private String siglas;

	@Column(name = "sobservacion", nullable = false, length = 200)
	private String sObservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	public Integer getnIdRol() {
		return nIdRol;
	}

	public void setnIdRol(Integer nIdRol) {
		this.nIdRol = nIdRol;
	}

	public String getsNombreRol() {
		return sNombreRol;
	}

	public void setsNombreRol(String sNombreRol) {
		this.sNombreRol = sNombreRol;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
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
