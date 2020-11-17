package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Perfil {

	private int nidperfil;
	private String snombreperfil;
	private int nsesionesporusuario;
	private int ntiempoconexionminuto;
	private int ntiempovidapasworddia;
	private boolean bactivo;
	private Date dfechareg;
	private int nidsesion;

}
