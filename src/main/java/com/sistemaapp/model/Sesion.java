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
	private Integer nidsesion;
	
	@Column(name = "dfechainicio", nullable = false)
	private LocalDate dfechainicio;
	
	@Column(name = "dfechafin", nullable = false)
	private LocalDate dfechafin;
	
	@Column(name = "ssistemaversion", nullable = false, length = 50)
	private String ssistemaversion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bactivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dfechareg;
	
	@ManyToOne
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_sesion_nidusuario_usuario_nidusuario"))
	private Usuario usuario;
 
	
}
