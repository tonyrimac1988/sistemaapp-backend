package com.sist.org.dto;
import java.util.List;

import lombok.Data;

@Data
public class RespuestaBase<T> {

	private String estado; 
	private String mensaje;
	private List<T> data;
	
	
	public RespuestaBase(String estado, String mensaje, List<T> data) {
		this.estado = estado;
		this.mensaje = mensaje;
		this.data = data;
	}


	public RespuestaBase() {
		
	}
	
	
	
}
