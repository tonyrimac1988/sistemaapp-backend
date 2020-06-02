package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name = "login", nullable = false, length = 50)
	private String login;
	
	@Column(name = "password", nullable = false, length = 30)
	private String password;
	
	@Column(name = "num_docu", nullable = false, length = 15)
	private String numDocu;
	
	@Column(name = "nombre", nullable = false, length = 80)
	private String nombre;
	
	@Column(name = "ape_paterno", nullable = false, length = 80)
	private String apePaterno;
	
	@Column(name = "ape_materno", nullable = false, length = 80)
	private String apeMaterno;
	
	@Column(name = "fecha_nac", nullable = false)
	private LocalDate fechaNac;
	
	@Column(name = "genero", nullable = false, length = 1)
	private String genero;
	
	@Column(name = "observacion", length = 500)
	private String observacion;
	
	@Column(name = "idUsuarioPadre", nullable = false)
	private Integer idUsuarioPadre;
//	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
  
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumDocu() {
		return numDocu;
	}

	public void setNumDocu(String numDocu) {
		this.numDocu = numDocu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getIdUsuarioPadre() {
		return idUsuarioPadre;
	}

	public void setIdUsuarioPadre(Integer idUsuarioPadre) {
		this.idUsuarioPadre = idUsuarioPadre;
	}

	public LocalDate getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}

	public boolean isbActivo() {
		return bActivo;
	}

	public void setbActivo(boolean bActivo) {
		this.bActivo = bActivo;
	}
	
	
	
}
