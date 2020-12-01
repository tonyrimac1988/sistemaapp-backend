package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Operador {
	private int nidoperador;
	private String snumdocu;
	private String snombre;
	private String sapepaterno;
	private String sapematerno;
	private String sgenero;
	private Date dfechanac;
	private String sobservacion;
	private boolean bactivo;
	private String estado;
	private Date dfechareg;
	private int nidsesion;
	private String scorreo;
	private Usuario usuario;
}
