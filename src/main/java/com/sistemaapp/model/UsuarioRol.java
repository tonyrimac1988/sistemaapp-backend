package com.sistemaapp.model;

import java.time.LocalDateTime;

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
@Table(name = "usuario_rol")
public class UsuarioRol {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidusuariorol")
	private Integer nIdUsuarioRol;
	
	@ManyToOne
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_usuariorol_nidusuario_usuario_nidusuario"))
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "nidrol", nullable = false, foreignKey = @ForeignKey(name = "fk_usuariorol_nidrol_rol_nidrol"))
	private Rol rol;
	
	@Column(name = "sobservacion", nullable = false, length = 500)
	private String sObservacion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dFechaReg;
	
	@Column(name = "nidsesion")
	private Integer nIdSesion;
  
	
}
