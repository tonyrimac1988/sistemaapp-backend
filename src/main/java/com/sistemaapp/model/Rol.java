package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidrol")
	private Integer nIdRol;

	@Column(name = "snombrerol", nullable = false, length = 100)
	private String sNombreRol;
	
	@Column(name = "siglas", nullable = false, length = 20)
	private String siglas;

	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sObservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	@Column(name = "nidsesion")
	private Integer nIdSesion;
	 

}
