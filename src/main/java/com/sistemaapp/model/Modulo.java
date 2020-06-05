package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modulo")
public class Modulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidmodulo")
	private Integer nIdModulo;
	
	@Column(name = "snombremodulo", nullable = false, length = 100)
	private String sNombreModulo;
	
	@Column(name = "ssiglas", nullable = false, length = 10)
	private String sSiglas;
	
	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sObservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	public Integer getnIdModulo() {
		return nIdModulo;
	}

	public void setnIdModulo(Integer nIdModulo) {
		this.nIdModulo = nIdModulo;
	}

	public String getsNombreModulo() {
		return sNombreModulo;
	}

	public void setsNombreModulo(String sNombreModulo) {
		this.sNombreModulo = sNombreModulo;
	}

	public String getsSiglas() {
		return sSiglas;
	}

	public void setsSiglas(String sSiglas) {
		this.sSiglas = sSiglas;
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
	

	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	

	
	
}
