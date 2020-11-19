package com.sist.org.mapper;

import java.util.List;

import com.sist.org.dto.UsuarioSesion;
import com.sist.org.modelo.Operador;
import com.sist.org.modelo.Pageable;

public interface IUsuarioMapper {
 
	List<Operador> listarUsuario(Pageable pageable);

	int countElements();

	UsuarioSesion ConsultaUsuariosesion(String usuario);

}
