package com.sistemaapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemaapp.model.Menu;

public interface IMenuRepo extends JpaRepository<Menu, Integer>{

	
	@Query(value="SELECT \r\n" + 
			"  public.menu.nidmenu,\r\n" + 
			"  public.menu.bactivo,\r\n" + 
			"  public.menu.dfechareg,\r\n" + 
			"  public.menu.nidsesion,\r\n" + 
			"  public.menu.siconomenu,\r\n" + 
			"  public.menu.snombremenu,\r\n" + 
			"  public.menu.surl,\r\n" + 
			"  public.menu.nidmodulo\r\n" + 
			"FROM\r\n" + 
			"  public.usuario\r\n" + 
			"  INNER JOIN public.usuario_rol ON (public.usuario.nidusuario = public.usuario_rol.nidusuario)\r\n" + 
			"  INNER JOIN public.rol ON (public.usuario_rol.nidrol = public.rol.nidrol)\r\n" + 
			"  INNER JOIN public.menu_rol ON (public.rol.nidrol = public.menu_rol.nidrol)\r\n" + 
			"  INNER JOIN public.menu ON (public.menu_rol.nidmenu = public.menu.nidmenu)\r\n" + 
			"WHERE public.usuario.slogin= :nombre;", nativeQuery = true)
	List<Object[]> listarMenuPorUsuario(@Param("nombre") String nombre);

	
	
	@Query(value="SELECT \r\n" + 
			"  public.menu.snombremenu\r\n" + 
			"FROM\r\n" + 
			"  public.usuario\r\n" + 
			"  INNER JOIN public.usuario_rol ON (public.usuario.nidusuario = public.usuario_rol.nidusuario)\r\n" + 
			"  INNER JOIN public.rol ON (public.usuario_rol.nidrol = public.rol.nidrol)\r\n" + 
			"  INNER JOIN public.menu_rol ON (public.rol.nidrol = public.menu_rol.nidrol)\r\n" + 
			"  INNER JOIN public.menu ON (public.menu_rol.nidmenu = public.menu.nidmenu)\r\n" + 
			"WHERE public.usuario.slogin= :nombre  order by public.menu.nidmenu asc; ", nativeQuery = true)
	String[] MenuUsuario(@Param("nombre") String nombre);
	
	
	@Query(value="SELECT \r\n" + 
			"  nidmenu,\r\n" + 
			"  bactivo,\r\n" + 
			"  dfechareg,\r\n" + 
			"  nidsesion,\r\n" + 
			"  siconomenu,\r\n" + 
			"  snombremenu,\r\n" + 
			"  surl,\r\n" + 
			"  nidmodulo\r\n" + 
			"FROM \r\n" + 
			"  public.menu \r\n" + 
			"where snombremenu like :nombre ", nativeQuery = true)
	List<Object[]> listarMenuPorNombreMenu(@Param("nombre") String nombre);
	
	
}
