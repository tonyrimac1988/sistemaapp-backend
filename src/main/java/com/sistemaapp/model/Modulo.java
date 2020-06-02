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
	private Integer idModulo;
	
	@Column(name = "nombre_modulo", nullable = false, length = 100)
	private String nombreModulo;
	
	@Column(name = "siglas", nullable = false, length = 10)
	private String siglas;
	
	@Column(name = "observacion", nullable = false, length = 500)
	private String observacion;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public boolean isbActivo() {
		return bActivo;
	}

	public void setbActivo(boolean bActivo) {
		this.bActivo = bActivo;
	}

	public LocalDate getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	

}
