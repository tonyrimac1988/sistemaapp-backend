package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidperfil")
	private Integer nIdPerfil;
	
	@Column(name = "snombreperfil", nullable = false, length = 80)
	private String sNombrePerfil;
	
	@Column(name = "nsesionporusuario", nullable = false)
	private Integer nSesionPorUsuario;
	
	@Column(name = "ntiempoconexion", nullable = false)
	private Integer nTiempoConexion;
	
	@Column(name = "ntiempovidapasword", nullable = false)
	private Integer nTiempoVidaPasword;
	  
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	public Integer getnIdPerfil() {
		return nIdPerfil;
	}

	public void setnIdPerfil(Integer nIdPerfil) {
		this.nIdPerfil = nIdPerfil;
	}

	public String getsNombrePerfil() {
		return sNombrePerfil;
	}

	public void setsNombrePerfil(String sNombrePerfil) {
		this.sNombrePerfil = sNombrePerfil;
	}

	public Integer getnSesionPorUsuario() {
		return nSesionPorUsuario;
	}

	public void setnSesionPorUsuario(Integer nSesionPorUsuario) {
		this.nSesionPorUsuario = nSesionPorUsuario;
	}

	public Integer getnTiempoConexion() {
		return nTiempoConexion;
	}

	public void setnTiempoConexion(Integer nTiempoConexion) {
		this.nTiempoConexion = nTiempoConexion;
	}

	public Integer getnTiempoVidaPasword() {
		return nTiempoVidaPasword;
	}

	public void setnTiempoVidaPasword(Integer nTiempoVidaPasword) {
		this.nTiempoVidaPasword = nTiempoVidaPasword;
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
