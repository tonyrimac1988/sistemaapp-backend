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
	@Column(name = "nidarea")
	private Integer nIdArea; 
	
	@Column(name = "snombre", nullable = false, length = 100)
	private String sNombre;
	
	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sObservacion;
	
	@Column(name = "nidareapadre", nullable = false)
	private Integer nIdAreaPadre;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	@ManyToOne
	@JoinColumn(name = "nidsede", nullable = false, foreignKey = @ForeignKey(name = "fk_area_nidarea_sede_nidsede"))
	private Sede sede;
	 
	
	public Integer getnIdArea() {
		return nIdArea;
	}

	public void setnIdArea(Integer nIdArea) {
		this.nIdArea = nIdArea;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsObservacion() {
		return sObservacion;
	}

	public void setsObservacion(String sObservacion) {
		this.sObservacion = sObservacion;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Integer getnIdAreaPadre() {
		return nIdAreaPadre;
	}

	public void setnIdAreaPadre(Integer nIdAreaPadre) {
		this.nIdAreaPadre = nIdAreaPadre;
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
