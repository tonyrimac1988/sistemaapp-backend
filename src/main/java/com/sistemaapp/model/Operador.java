package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
 
@Data
@Entity
@Table(name = "operador")
public class Operador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidoperador")
	private Integer nIdOperador;
	
	@Column(name = "snumdocu", nullable = false, length = 15)
	private String sNumDocu;
	
	@Column(name = "snombre", nullable = false, length = 80)
	private String sNombre;
	
	@Column(name = "sapepaterno", nullable = false, length = 80)
	private String sApePaterno;
	
	@Column(name = "sapematerno", nullable = false, length = 80)
	private String sApeMaterno;
	
	@Column(name = "dfechanac", nullable = false)
	private LocalDate dFechaNac;
	
	@Column(name = "sgenero", nullable = false, length = 1)
	private String sGenero;
	
	@Column(name = "sobservacion", length = 500)
	private String sObservacion;
		
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;

	@Column(name = "nidsesion")
	private Integer nIdSesion;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "operador")
	private Usuario usuario;
	 
	
}
