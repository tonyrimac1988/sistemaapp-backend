package com.sist.org.mapper;

import java.util.List;

import com.sist.org.dto.RolMenuDTO;
import com.sist.org.modelo.Menu;
import com.sist.org.modelo.Procedimiento;

public interface IMenuMapper {

	List<Menu> listarMenuPorUsuario(String nombre);

	List<Menu> listarmenusubmenu();

	List<Menu> consultapermisomenu(RolMenuDTO rolmenu);

	List<Procedimiento> validarpermisosrolmenu(RolMenuDTO rolmeu);

}
