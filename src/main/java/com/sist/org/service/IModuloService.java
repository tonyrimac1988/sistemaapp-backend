package com.sist.org.service;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Modulo;

public interface IModuloService {

	String insertarModulo(@Valid Modulo modulo);

	List<Modulo> listarModulo();

	String actualizarModulo(@Valid Modulo modulo);

	String eliminarModulo(@Valid Modulo modulo);

}
