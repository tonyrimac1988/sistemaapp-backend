package com.sist.org.mapper;

import java.util.List;

import com.sist.org.modelo.Ubigeo;

public interface IUbigeoMapper {

	List<Ubigeo> listarDepartamento();

	List<Ubigeo> listarprovincia(String iddepartamento);

	List<Ubigeo> listardistrito(String idprovincia);

}
