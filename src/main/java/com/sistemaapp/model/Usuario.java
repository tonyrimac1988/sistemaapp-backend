package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
 
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@Column(name = "nidusuario")
	private Integer nidusuario;
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "nidusuario", nullable = false)
	private Operador operador;
	 
	@Column(name = "slogin", nullable = false, length = 50)
	private String slogin;
	
	@Column(name = "spassword", nullable = false, length = 100)
	private String spassword;
	
 
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dfechareg;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bactivo;

	@Column(name = "nidsesion")
	private Integer nidsesion;
	 
	
}
