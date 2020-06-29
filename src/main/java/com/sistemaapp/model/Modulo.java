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
@Table(name = "modulo")
public class Modulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidmodulo")
	private Integer nIdModulo;
	
	@Column(name = "snombremodulo", nullable = false, length = 100)
	private String sNombreModulo;
	
	@Column(name = "ssiglas", nullable = false, length = 10)
	private String sSiglas;
	
	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sObservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	@Column(name = "nidsesion")
	private Integer nIdSesion;
	 
 
	
}
