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
@Table(name = "usuario_biometria")
public class UsuarioBiometria {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidusuariobiometria")
	private Integer nIdUsuarioBiometria;
	
	@Column(name = "ximagen", nullable = false)
	private byte[] xImagen;
	
	@Column(name = "stipoimagen", nullable = false , length = 25)
	private String sTipoImagen;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dFechaReg;
	
	@ManyToOne
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_usuariobiometria_nidusuario_usuario_nidusuario"))
	private Usuario usuario;

	@Column(name = "nidsesion")
	private Integer nIdSesion;
	
	 
}
