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
	private Integer idSede;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "ubigeo", nullable = false, length = 50)
	private String ubigeo;
	
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;
	
	@Column(name = "id_sede_padre", nullable = false)
	private Integer idSedePadre;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDateTime fechaReg;

	
	
	public Integer getIdSede() {
		return idSede;
	}

	public void setIdSede(Integer idSede) {
		this.idSede = idSede;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getIdSedePadre() {
		return idSedePadre;
	}

	public void setIdSedePadre(Integer idSedePadre) {
		this.idSedePadre = idSedePadre;
	}

	public boolean isbActivo() {
		return bActivo;
	}

	public void setbActivo(boolean bActivo) {
		this.bActivo = bActivo;
	}

	public LocalDateTime getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDateTime fechaReg) {
		this.fechaReg = fechaReg;
	}
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	

	
	 

}
