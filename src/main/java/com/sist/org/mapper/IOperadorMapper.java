package com.sist.org.mapper;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.dto.ImagenOperadorDto;
import com.sist.org.dto.OperadorDto;
import com.sist.org.modelo.Operador;
import com.sist.org.util.Pageable;

public interface IOperadorMapper {

	List<OperadorDto> listarOperador(Pageable pageable);

	List<OperadorDto> buscaroperador(Pageable pageable);
	
	String eliminarOperador(int operador);

	String actualizarOperador(Operador operador);

	String insertarOperador(OperadorDto operador);

	String modificarUsuarioOperador(OperadorDto operadorDto);

	int countElements(Pageable pageable);

	ImagenOperadorDto consultarimagenoperador(int idoperador);

	String reactivaroperador(@Valid int operador);

	
		
}