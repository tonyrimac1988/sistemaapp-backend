package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class TipoDocumento {

	private String sidtipodoc;
	private String sdescripcion;
	private boolean bactivo;
	private Date dfechareg;
	private int nidsesion;
	
}
