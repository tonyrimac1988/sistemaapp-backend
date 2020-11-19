package com.sist.org.mapper;

public interface ISesionMapper {

	String InciarSesion(String usuario);

	Integer CerrarSesion(int usuario);

}
