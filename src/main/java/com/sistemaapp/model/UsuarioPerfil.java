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
@Table(name = "usuario_perfil")
public class UsuarioPerfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidusuarioperfil")
	private Integer nIdUsuarioPerfil;
	
 
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "sobservacion", length = 500)
	private String sObservacion;	
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dFechaReg;
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;
//	
	@ManyToOne
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarioperfil_nidusuario_usuario_nidusuario"))
	private Usuario usuario;

	
	@ManyToOne
	@JoinColumn(name = "nidperfil", nullable = false, foreignKey = @ForeignKey(name = "fk_usuarioperfil_nidperfil_perfil_nidperfil"))
	private Perfil perfil;

	@Column(name = "nidsesion")
	private Integer nIdSesion;
	
}
