package com.sist.org.dto;

import java.util.Date;
 
import lombok.Data;


@Data
public class SedeDTO {
	
	private Integer nidsede;
	private boolean bactivo;
	private Date dfechareg;
	private String sdireccion;
	private String sdireccioncompleta;
	private String snombre;
	private String subigeo;
	
}
