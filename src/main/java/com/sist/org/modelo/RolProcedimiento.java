package com.sist.org.modelo;

import java.util.Date;

import lombok.Data;

@Data
public class RolProcedimiento {

	private int nidprocedimiento;
	private int nidrol;
	private boolean bactivo;
	private Date dfechareg;
	
}
