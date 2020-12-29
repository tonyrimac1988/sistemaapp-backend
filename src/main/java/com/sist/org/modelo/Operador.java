package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Operador {
	
	private int nidoperador;
	private String sidtipodoc;
	private String snumdocu;
	private String snombre;
	private String sapepaterno;
	private String sapematerno;
	private String scorreo;
	private String sgenero;
	private String stelefono;
	private Date dfechanac;
	private String sdireccion;
	private String sobservacion;
	private boolean bactivo;
	private String estado;
	private Date dfechareg;
	private int nidsesion;
	private Usuario usuario;
}
