package com.sistemaapp.model;

import java.time.LocalDateTime;

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
	private Integer nidmodulo;
	
	@Column(name = "snombremodulo", nullable = false, length = 100)
	private String snombremodulo;
	
	@Column(name = "ssiglas", nullable = false, length = 10)
	private String ssiglas;
	
	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sobservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bactivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dfechareg;

	@Column(name = "nidsesion")
	private Integer nidsesion;
	 
 
	
}
