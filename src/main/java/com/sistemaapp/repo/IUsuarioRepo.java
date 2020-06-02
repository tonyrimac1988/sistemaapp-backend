package com.sistemaapp.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaapp.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	
}
