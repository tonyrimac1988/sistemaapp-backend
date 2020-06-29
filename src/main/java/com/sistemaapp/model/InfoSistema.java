package com.sistemaapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "info_sistema")
public class InfoSistema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidinfosistema")
	private Integer nIdInfoSistema;
	
	@Column(name = "sversion", nullable = false, length = 50)
	private String sVersion;
	
	@Column(name = "snombresistema", nullable = false, length = 100)
	private String sNombreSistema;
	
	@Column(name = "slogo", nullable = false)
	private byte[] sLogo;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bActivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dFechaReg;
 
	 
	
}
