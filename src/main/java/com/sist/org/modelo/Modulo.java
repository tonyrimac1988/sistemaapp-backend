package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Modulo {

	private int nidmodulo;
	private String snombremodulo;
	private String ssiglas;
	private String sobservacion;
	private boolean bactivo;
	private Date dfechareg;
	private int nidsesion;

}
