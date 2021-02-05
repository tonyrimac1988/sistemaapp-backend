package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class Procedimiento {

	private int nidprocedimiento;
	private int nidmenu;
	private String setiqueta;
	private String sdescripcion;
	private boolean bactivo;
	private Date dfechahoraaud;
}
