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
@Table(name = "perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidperfil")
	private Integer nidperfil;
	
	@Column(name = "snombreperfil", nullable = false, length = 80)
	private String snombreperfil;
	
	@Column(name = "nsesionesporusuario", nullable = false)
	private Integer nsesionesporusuario;
	
	@Column(name = "ntiempoconexionminuto", nullable = false)
	private Integer ntiempoconexionminuto;
	
	@Column(name = "ntiempovidapasworddia", nullable = false)
	private Integer ntiempovidapasworddia;
	  
	@Column(name = "bactivo", nullable = false)
	private boolean bactivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dfechareg;

	@Column(name = "nidsesion")
	private Integer nidsesion;
	 

}
