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

import lombok.Data;

@Data
@Entity
@Table(name = "sesion")
public class Sesion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidsesion")
	private Integer nIdSesion;
	
	@Column(name = "dfechainicio", nullable = false)
	private LocalDate dFechaInicio;
	
	@Column(name = "dfechafin", nullable = false)
	private LocalDate dFechaFin;
	
	@Column(name = "ssistemaversion", nullable = false, length = 50)
	private String sSistemaVersion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;
	
	@ManyToOne
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_sesion_nidusuario_usuario_nidusuario"))
	private Usuario usuario;
 
	
}
