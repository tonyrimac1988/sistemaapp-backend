package com.sist.org.service;
import com.sist.org.dto.OperadorDto;
import com.sist.org.modelo.Operador;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;
import com.sist.org.util.ReporteRespuesta;

public interface IOperadorService {

	Page<OperadorDto> listarOperador(Pageable pageable);

	String eliminarOperador(int operador);
	
	String actualizarOperador(Operador operador);

	String insertarOperador(OperadorDto operador);

	String modificarUsuarioOperador(OperadorDto operadorDto);

	ReporteRespuesta generarReporte(String tipoReporte);
 
}
