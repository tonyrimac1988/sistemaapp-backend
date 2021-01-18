package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Ubigeo {
	
	private String sidubigeo;
	private String snombre;
	private String scodanterior;
	private boolean bactivo;
	private int nidsesion;
	private Date dfechahoraaud;

}
