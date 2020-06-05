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
@Table(name = "usuario_perfil")
//@IdClass(UsuarioPerfilPK.class)
public class UsuarioPerfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidusuarioperfil")
	private Integer nIdUsuarioPerfil;
	
 
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
	@JoinColumn(name = "nidusuario", nullable = false, foreignKey = @ForeignKey(name = "fk_id_usuarioperfil_nidusuario_usuario_nidusuario"))
	private Usuario usuario;

	
	@ManyToOne
	@JoinColumn(name = "nidperfil", nullable = false, foreignKey = @ForeignKey(name = "fk_id_usuarioperfil_nidperfil_perfil_nidperfil"))
	private Perfil perfil;

	
	
}
