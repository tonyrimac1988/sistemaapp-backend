package com.sist.org.mapper;

import java.util.List;

import com.sist.org.modelo.Menu;

public interface IMenuMapper {

	List<Menu> listarMenuPorUsuario(String nombre);

}
