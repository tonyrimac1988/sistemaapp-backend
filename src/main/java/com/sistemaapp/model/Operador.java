package com.sistemaapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
	private Integer nidoperador;
	
	@Column(name = "snumdocu", nullable = false, length = 15)
	private String snumdocu;
	
	@Column(name = "snombre", nullable = false, length = 80)
	private String snombre;
	
	@Column(name = "sapepaterno", nullable = false, length = 80)
	private String sapepaterno;
	
	@Column(name = "sapematerno", nullable = false, length = 80)
	private String sapematerno;
	
	@Column(name = "dfechanac", nullable = false)
	private LocalDate dfechanac;
	
	@Column(name = "sgenero", nullable = false, length = 1)
	private String sgenero;
	
	@Column(name = "sobservacion", length = 500)
	private String sobservacion;
		
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dfechareg;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bactivo;

	@Column(name = "nidsesion")
	private Integer nidsesion;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "operador")
	private Usuario usuario;
	 
	
}
