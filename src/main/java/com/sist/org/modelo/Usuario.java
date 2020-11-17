package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Usuario {

	private int nidusuario;
	private String slogin;
	private String spassword;
	private boolean bactivo;
	private Date dfechareg;
	private int nidsesion;
	
}
