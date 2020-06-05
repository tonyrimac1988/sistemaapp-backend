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
	@Column(name = "nidusuario")
	private Integer nIdUsuario;
	
	@Column(name = "slogin", nullable = false, length = 50)
	private String sLogin;
	
	@Column(name = "spassword", nullable = false, length = 100)
	private String sPassword;
	
	@Column(name = "snumdocu", nullable = false, length = 15)
	private String sNumDocu;
	
	@Column(name = "snombre", nullable = false, length = 80)
	private String sNombre;
	
	@Column(name = "sapepaterno", nullable = false, length = 80)
	private String sApePaterno;
	
	@Column(name = "sapematerno", nullable = false, length = 80)
	private String sApeMaterno;
	
	@Column(name = "dfechanac", nullable = false)
	private LocalDate dFechaNac;
	
	@Column(name = "sgenero", nullable = false, length = 1)
	private String sGenero;
	
	@Column(name = "sobservacion", length = 500)
	private String sObservacion;
	
	@Column(name = "nidusuariopadre", nullable = false)
	private Integer nIdUsuarioPadre;
//	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;

	public Integer getnIdUsuario() {
		return nIdUsuario;
	}

	public void setnIdUsuario(Integer nIdUsuario) {
		this.nIdUsuario = nIdUsuario;
	}

	public String getsLogin() {
		return sLogin;
	}

	public void setsLogin(String sLogin) {
		this.sLogin = sLogin;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public String getsNumDocu() {
		return sNumDocu;
	}

	public void setsNumDocu(String sNumDocu) {
		this.sNumDocu = sNumDocu;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsApePaterno() {
		return sApePaterno;
	}

	public void setsApePaterno(String sApePaterno) {
		this.sApePaterno = sApePaterno;
	}

	public String getsApeMaterno() {
		return sApeMaterno;
	}

	public void setsApeMaterno(String sApeMaterno) {
		this.sApeMaterno = sApeMaterno;
	}

	public LocalDate getdFechaNac() {
		return dFechaNac;
	}

	public void setdFechaNac(LocalDate dFechaNac) {
		this.dFechaNac = dFechaNac;
	}

	public String getsGenero() {
		return sGenero;
	}

	public void setsGenero(String sGenero) {
		this.sGenero = sGenero;
	}

	public String getsObservacion() {
		return sObservacion;
	}

	public void setsObservacion(String sObservacion) {
		this.sObservacion = sObservacion;
	}

	public Integer getnIdUsuarioPadre() {
		return nIdUsuarioPadre;
	}

	public void setnIdUsuarioPadre(Integer nIdUsuarioPadre) {
		this.nIdUsuarioPadre = nIdUsuarioPadre;
	}

	public LocalDate getdFechaReg() {
		return dFechaReg;
	}

	public void setdFechaReg(LocalDate dFechaReg) {
		this.dFechaReg = dFechaReg;
	}

	public boolean isbActivo() {
		return bActivo;
	}

	public void setbActivo(boolean bActivo) {
		this.bActivo = bActivo;
	}

	 
	
	
	
	
	
}
