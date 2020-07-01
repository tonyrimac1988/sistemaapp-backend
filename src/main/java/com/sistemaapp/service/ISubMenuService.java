package com.sistemaapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistemaapp.model.SubMenu;

public interface ISubMenuService extends ICRUD<SubMenu, Integer>{

	Page<SubMenu> listarPageable(Pageable pageable);

}
