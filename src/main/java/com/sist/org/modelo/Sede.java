package com.sist.org.modelo;
import java.util.Date;

import lombok.Data;
 
@Data
public class Sede {
	
	private Integer nidsede;
	private boolean bactivo;
	private Date dfechareg;
	private String sdireccion;
	private String snombre;
	private String subigeo;

}
