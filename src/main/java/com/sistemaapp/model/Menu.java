package com.sistemaapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidmenu")
	private Integer nidmenu;
	
	@Column(name = "snombremenu", nullable = false, length = 100)
	private String snombremenu;
	
	@Column(name = "siconomenu", nullable = false, length = 50)
	private String siconomenu;
	
	@Column(name = "surl", nullable = false, length = 50)
	private String surl;
	
	@Column(name = "norden", nullable = false)
	private Integer norden;
	
	@Column(name = "bactivo", nullable = true)
	private boolean bactivo;
	
	@ManyToOne
	@JoinColumn(name = "nidmodulo", nullable = false, foreignKey = @ForeignKey(name = "fk_menu_nidmodulo_modulo_nidmodulo"))
	private Modulo modulo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDate dfechareg;

	@Column(name = "nidsesion")
	private Integer nidsesion;
  
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "nidmenu", foreignKey = @ForeignKey(name = "fk_menu_nidmenu_submenu_nidmenu"))
    private List<SubMenu> submenu;

	
	
}
