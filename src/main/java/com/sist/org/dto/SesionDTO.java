package com.sist.org.dto;

import java.util.Date;

import lombok.Data;


@Data
public class SesionDTO {

	private int nidsesion;
	private String slogin;
	private String snombres;
	private Date dfechainicio; 
	private Date dfechafin;
	private String ssistemaversion;
	private String estadosesion;
	 
}
