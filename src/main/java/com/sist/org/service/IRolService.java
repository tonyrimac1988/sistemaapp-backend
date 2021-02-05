package com.sist.org.service;
import java.util.List;

import javax.validation.Valid;

import com.sist.org.modelo.Rol;
import com.sist.org.modelo.RolProcedimiento;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

public interface IRolService {

	String insertarRol(@Valid Rol rol);

	List<Rol> listarRol();

	String actualizarRol(@Valid Rol rol);

	String eliminarRol(@Valid Rol rol);

	Integer ListarAreaUsuario(Integer idUsuario);

	Page<Rol> listarRolPage(Pageable pageable);

	String registrarrolprocedimiento(@Valid RolProcedimiento rolprocedimiento);

	String registrarrolprocedimientoLista(@Valid List<RolProcedimiento> listarolprocedimiento);

}
