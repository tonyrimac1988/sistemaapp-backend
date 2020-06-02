package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_perfil")
@IdClass(UsuarioPerfilPK.class)
public class UsuarioPerfil {
	
	@Id
	private Integer idUsuarioPerfil;
	
	@Id
	private Perfil perfil;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "observacion", length = 500)
	private String observacion;	
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
//	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "id_usuario_perfil"))
	private Usuario usuario;

}
