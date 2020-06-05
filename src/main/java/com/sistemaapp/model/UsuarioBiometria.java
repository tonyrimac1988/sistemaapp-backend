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
@Table(name = "usuario_biometria")
public class UsuarioBiometria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidusuariobiometria")
	private Integer nIdUsuarioBiometria;
	
	@Column(name = "ximagen", nullable = false)
	private byte[] xImagen;
	
	@Column(name = "stipoimagen", nullable = false)
	private String sTipoImagen;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;
	
	@ManyToOne
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_usuariobiometria_nidusuario_usuario_nidusuario"))
	private Usuario usuario;

	public Integer getnIdUsuarioBiometria() {
		return nIdUsuarioBiometria;
	}

	public void setnIdUsuarioBiometria(Integer nIdUsuarioBiometria) {
		this.nIdUsuarioBiometria = nIdUsuarioBiometria;
	}

	public byte[] getxImagen() {
		return xImagen;
	}

	public void setxImagen(byte[] xImagen) {
		this.xImagen = xImagen;
	}

	public String getsTipoImagen() {
		return sTipoImagen;
	}

	public void setsTipoImagen(String sTipoImagen) {
		this.sTipoImagen = sTipoImagen;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	
	
}
