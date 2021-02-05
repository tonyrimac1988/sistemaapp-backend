package com.sist.org.service;

import java.util.List;

import com.sist.org.dto.RolMenuDTO;
import com.sist.org.modelo.Menu;
import com.sist.org.modelo.Procedimiento;


public interface IMenuService {

	List<Menu> listarMenuPorUsuario(String nombre);

	List<Menu> listarmenusubmenu();

	List<Menu> consultapermisomenu(RolMenuDTO rolmenu);

	List<Procedimiento> validarpermisosrolmenu(RolMenuDTO rolmeu);
 
 

}
