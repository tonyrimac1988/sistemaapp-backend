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
	private Integer nIdPerfil;
	
	@Column(name = "snombreperfil", nullable = false, length = 80)
	private String sNombrePerfil;
	
	@Column(name = "nsesionesporusuario", nullable = false)
	private Integer nSesionesPorUsuario;
	
	@Column(name = "ntiempoconexionminuto", nullable = false)
	private Integer nTiempoConexionMinuto;
	
	@Column(name = "ntiempovidapasworddia", nullable = false)
	private Integer nTiempoVidaPaswordDia;
	  
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	@Column(name = "nidsesion")
	private Integer nIdSesion;
	 

}
