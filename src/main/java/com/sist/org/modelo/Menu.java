package com.sist.org.modelo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Menu {

	private int nidmenu;
	private int norden;
	private String snombremenu;
	private String siconomenu;
	private String surl;
	private int nidmodulo;
	private boolean bactivo;
	private Date dfechareg;
	private int nidsesion;
	private List<SubMenu> submenu ;
}
