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
@Table(name = "area")
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidarea")
	private Integer nIdArea; 
	
	@Column(name = "snombre", nullable = false, length = 100)
	private String sNombre;
	
	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sObservacion;
		
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	@ManyToOne
	@JoinColumn(name = "nidsede", nullable = false, foreignKey = @ForeignKey(name = "fk_area_nidsede_sede_nidsede"))
	private Sede sede;
	 
	@Column(name = "nidsesion")
	private Integer nIdSesion;
	 
	 

}
