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
@Table(name = "usuario_area")
public class UsuarioArea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidusuarioarea")
	private Integer nIdUsuarioArea;
	
	@ManyToOne
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarioarea_nidusuario_usuario_nidusuario"))
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "nidarea", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarioarea_nidarea_area_nidarea"))
	private Area area;
	
	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sObservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;

	@Column(name = "nidsesion")
	private Integer nIdSesion;
	 
	
}
