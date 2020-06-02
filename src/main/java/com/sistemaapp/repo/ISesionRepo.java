package com.sistemaapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaapp.model.Sesion;

public interface ISesionRepo extends JpaRepository<Sesion, Integer>{
	

}
