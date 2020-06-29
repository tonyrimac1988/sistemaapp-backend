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
@Table(name = "sede")
public class Sede {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidsede")
	private Integer nIdSede;
	
	@Column(name = "snombre", nullable = false, length = 100)
	private String sNombre;
	
	@Column(name = "subigeo", nullable = false, length = 50)
	private String sUbigeo;
	
	@Column(name = "sdireccion", nullable = false, length = 150)
	private String sDireccion;
		
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dFechaReg;
 
	  
}
