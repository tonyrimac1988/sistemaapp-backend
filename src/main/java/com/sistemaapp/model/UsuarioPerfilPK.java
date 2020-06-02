package com.sistemaapp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UsuarioPerfilPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuarioPerfil;

	@ManyToOne
	@JoinColumn(name = "id_perfil", nullable = false, foreignKey = @ForeignKey(name = "id_perfil_usuario"))
	private Perfil perfil;

}
