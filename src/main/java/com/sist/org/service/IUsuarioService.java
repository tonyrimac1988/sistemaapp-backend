package com.sist.org.service;

import com.sist.org.modelo.Operador;
import com.sist.org.modelo.Page;
import com.sist.org.modelo.Pageable;

public interface IUsuarioService {

	Page<Operador> listarUsuario(Pageable pageable);
  

}
