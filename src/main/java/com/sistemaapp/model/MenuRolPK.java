package com.sistemaapp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class MenuRolPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "nidrol", nullable = false)
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "nidmenu", nullable = false)
	private Menu menu;
 
	
	
}
