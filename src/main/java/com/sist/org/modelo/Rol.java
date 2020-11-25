package com.sist.org.modelo;
import java.util.Date;

import lombok.Data;

@Data
public class Rol {

	private Integer nidrol;
	private boolean bactivo;
	private Date dfechareg;
	private Integer nidsesion;
	private String siglas;
	private String snombrerol;
	private String sobservacion;
}
