package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_rol")
@IdClass(UsuarioRolPK.class)
public class UsuarioRol {
	
	@Id
	private Usuario usuario;
	
	@Id
	private Rol rol;
	
	@Column(name = "observacion", nullable = false, length = 500)
	private String observacion;
	
	@Column(name = "bActivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;
	
//	@Column(name = "id_sesion", nullable = false)
//	private Sesion sesion;

}
