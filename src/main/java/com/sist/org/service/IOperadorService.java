package com.sist.org.service;
import java.util.List;

import com.sist.org.modelo.Operador;

public interface IOperadorService {

	List<Operador> listarOperador();

	String eliminarOperador(Operador operador);
	
	String actualizarOperador(Operador operador);

	String insertarOperador(Operador operador);
}
