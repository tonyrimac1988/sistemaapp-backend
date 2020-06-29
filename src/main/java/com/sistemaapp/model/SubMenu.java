package com.sistemaapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "submenu")
public class SubMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidsubmenu")
	private Integer nIdSubMenu;
	
	@Column(name = "snombremenu", nullable = false, length = 100)
	private String sNombreMenu;
	
	@Column(name = "siconomenu", nullable = false, length = 50)
	private String sIconoMenu;
	
	@Column(name = "surl", nullable = false, length = 50)
	private String sUrl;
	
//	@ManyToOne
//	@JoinColumn(name = "nidmenu", nullable = false, foreignKey = @ForeignKey(name = "fk_submenu_nidmenu_menu_nidmenu"))
//	private Menu menu;
	
	
}
