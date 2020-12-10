package com.sist.org.dto;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class RespuestaBase<T> {

	private String estado; 
	private String mensaje;
	private List<T> data;
	
}
