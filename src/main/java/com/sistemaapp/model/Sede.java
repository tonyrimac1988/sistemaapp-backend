package com.sistemaapp.model;
 
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sede")
public class Sede {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidsede")
	private Integer nIdSede;
	
	@Column(name = "snombre", nullable = false, length = 100)
	private String sNombre;
	
	@Column(name = "subigeo", nullable = false, length = 50)
	private String sUbigeo;
	
	@Column(name = "sdireccion", nullable = false, length = 150)
	private String sDireccion;
	
	@Column(name = "nidsedepadre", nullable = false)
	private Integer nIdSedePadre;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dFechaReg;

	public Integer getnIdSede() {
		return nIdSede;
	}

	public void setnIdSede(Integer nIdSede) {
		this.nIdSede = nIdSede;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsUbigeo() {
		return sUbigeo;
	}

	public void setsUbigeo(String sUbigeo) {
		this.sUbigeo = sUbigeo;
	}

	public String getsDireccion() {
		return sDireccion;
	}

	public void setsDireccion(String sDireccion) {
		this.sDireccion = sDireccion;
	}

	public Integer getnIdSedePadre() {
		return nIdSedePadre;
	}

	public void setnIdSedePadre(Integer nIdSedePadre) {
		this.nIdSedePadre = nIdSedePadre;
	}

	public boolean isbActivo() {
		return bActivo;
	}

	public void setbActivo(boolean bActivo) {
		this.bActivo = bActivo;
	}

	public LocalDateTime getdFechaReg() {
		return dFechaReg;
	}

	public void setdFechaReg(LocalDateTime dFechaReg) {
		this.dFechaReg = dFechaReg;
	}

	 
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	

	
	 

}
