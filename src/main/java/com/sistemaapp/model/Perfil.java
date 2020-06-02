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
	private Integer idPerfil;
	
	@Column(name = "nombre_perfil", nullable = false, length = 80)
	private String nombrePerfil;
	
	@Column(name = "sesion_por_usuario", nullable = false)
	private Integer sesionPorUsuario;
	
	@Column(name = "tiempo_conexion", nullable = false)
	private Integer tiempoConexion;
	
	@Column(name = "pasword_tiempo_vida", nullable = false)
	private Integer paswordTiempoVida;
	
	@Column(name = "intentos_logeo", nullable = false)
	private Integer intentosLogeo;
	
	@Column(name = "cantidad_estacion", nullable = false)
	private Integer cantidadEstacion;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;

	
	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPefil) {
		this.idPerfil = idPefil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public Integer getSesionPorUsuario() {
		return sesionPorUsuario;
	}

	public void setSesionPorUsuario(Integer sesionPorUsuario) {
		this.sesionPorUsuario = sesionPorUsuario;
	}

	public Integer getTiempoConexion() {
		return tiempoConexion;
	}

	public void setTiempoConexion(Integer tiempoConexion) {
		this.tiempoConexion = tiempoConexion;
	}

	public Integer getPaswordTiempoVida() {
		return paswordTiempoVida;
	}

	public void setPaswordTiempoVida(Integer paswordTiempoVida) {
		this.paswordTiempoVida = paswordTiempoVida;
	}

	public Integer getIntentosLogeo() {
		return intentosLogeo;
	}

	public void setIntentosLogeo(Integer intentosLogeo) {
		this.intentosLogeo = intentosLogeo;
	}

	public Integer getCantidadEstacion() {
		return cantidadEstacion;
	}

	public void setCantidadEstacion(Integer cantidadEstacion) {
		this.cantidadEstacion = cantidadEstacion;
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
