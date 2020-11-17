package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Parametro {

	private int nidparametro;
	private boolean bactivo;
	private Date dfechareg;
	private String sclave;
	private String sdescripcion;
	private String svalor;
}
