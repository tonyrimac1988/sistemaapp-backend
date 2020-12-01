package com.sist.org.service;

import com.sist.org.dto.OperadorDto;
import com.sist.org.dto.UsuarioSesion;
import com.sist.org.modelo.Operador;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

public interface IUsuarioService {

	Page<Operador> listarUsuario(Pageable pageable);

	UsuarioSesion ConsultaUsuariosesion(String usuario);

	String modificarUsuarioOperador(OperadorDto operadorDto);
  

}
