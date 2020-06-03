package com.sistemaapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_procedimiento")
public class AuditoriaProcedimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAudProced;
	
	@Column(name = "data", nullable = false, length = 500)
	private String data;
	
	@Column(name = "palabra_clave", nullable = false, length = 100)
	private String palabraClave;
	
	@Column(name = "fecha_reg", nullable = false)
	private LocalDate fechaReg;

}
