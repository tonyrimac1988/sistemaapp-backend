package com.sist.org.service;

import java.util.List;

import com.sist.org.modelo.Menu;
import com.sist.org.modelo.Usuario;


public interface IMenuService {

	List<Menu> listarMenuPorUsuario(String nombre);
 

}
