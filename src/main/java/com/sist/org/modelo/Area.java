package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Area {

	private int nidarea;
	private String snombre;
	private String sobservacion;
	private int nidsede;
	private boolean bactivo;
	private Date dfechareg;
	private int nidsesion;
}
