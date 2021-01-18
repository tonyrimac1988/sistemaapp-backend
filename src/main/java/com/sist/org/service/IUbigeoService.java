package com.sist.org.service;

import java.util.List;

import com.sist.org.modelo.Ubigeo;

public interface IUbigeoService {

	List<Ubigeo> listarDepartamento();

	List<Ubigeo> listarprovincia(String iddepartamento);

	List<Ubigeo> listardistrito(String idprovincia);

}
