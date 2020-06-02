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

@Entity
@Table(name = "usuario_area")
public class UsuarioArea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdUsuarioArea;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "id_usuario_area"))
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_area", nullable = false, foreignKey = @ForeignKey(name = "id_area_usuario"))
	private Area area;
	
	@Column(name = "observacion", nullable = false, length = 200)
	private String observacion;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;

}
