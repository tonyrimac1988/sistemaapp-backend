package com.sist.org.mapper;
import java.util.List;

import com.sist.org.modelo.Operador;

public interface IOperadorMapper {

	List<Operador> listarOperador();

	String eliminarOperador(Operador operador);

	String actualizarOperador(Operador operador);

	String insertarOperador(Operador operador);
		
}