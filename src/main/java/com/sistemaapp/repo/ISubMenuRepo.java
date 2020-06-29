package com.sistemaapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaapp.model.Area;
import com.sistemaapp.model.SubMenu;

public interface ISubMenuRepo extends JpaRepository<SubMenu, Integer>{

	
}
