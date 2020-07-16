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
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidrol")
	private Integer nidrol;

	@Column(name = "snombrerol", nullable = false, length = 100)
	private String snombrerol;
	
	@Column(name = "siglas", nullable = false, length = 20)
	private String siglas;

	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sobservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bactivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dfechareg;

	@Column(name = "nidsesion")
	private Integer nidsesion;
	 

}
