package com.sist.org.mapper;

import java.util.List;

import com.sist.org.dto.OperadorDto;
import com.sist.org.dto.UsuarioSesion;
import com.sist.org.modelo.Operador;
import com.sist.org.util.Pageable;

public interface IUsuarioMapper {
 
	List<Operador> listarUsuario(Pageable pageable);

	int countElements();

	UsuarioSesion ConsultaUsuariosesion(String usuario);

	String modificarUsuarioOperador(OperadorDto operadorDto);

}
