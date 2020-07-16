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
@Table(name = "auditoria_procedimiento")
public class AuditoriaProcedimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nidaudproced")
	private Integer nIdAudProced;
	
	@Column(name = "sdata", nullable = false, length = 500)
	private String sData;
	
	@Column(name = "spalabraclave", nullable = false, length = 100)
	private String sPalabraClave;
	
	@Column(name = "dfechareg", nullable = false)
	private LocalDateTime dFechaReg;

}
