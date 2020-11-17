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
@Table(name = "parametro")
public class Parametro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidparametro")
	private Integer nidparametro;
	
	
	@Column(name = "sclave", nullable = false, length = 50)
	private String sclave;
	
	@Column(name = "svalor", nullable = false, length = 100)
	private String svalor;
	
	@Column(name = "sdescripcion", nullable = false, length = 200)
	private String sdescripcion;
	
	@Column(name = "bactivo", nullable = false)
	private boolean bactivo;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dfechareg;
 
	
}
