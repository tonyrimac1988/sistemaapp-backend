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
@Table(name = "area")
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArea; 
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "observacion", nullable = false, length = 500)
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name = "id_sede", nullable = false, foreignKey = @ForeignKey(name = "id_area_sede"))
	private Sede sede;
	
	@Column(name = "idAreaPadre", nullable = false)
	private Integer idAreaPadre;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;

//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	
	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Integer getIdAreaPadre() {
		return idAreaPadre;
	}

	public void setIdAreaPadre(Integer idAreaPadre) {
		this.idAreaPadre = idAreaPadre;
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
	

}
