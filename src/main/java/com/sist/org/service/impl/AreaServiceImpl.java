package com.sist.org.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.IAreaMapper;
import com.sist.org.modelo.Area;
import com.sist.org.service.IAreaService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;

@Service
public class AreaServiceImpl implements IAreaService{
	
	@Autowired
	IAreaMapper areamapper;

	@Override
	public String insertarArea(@Valid Area area) {
		// TODO Auto-generated method stub
		return areamapper.insertarArea(area);
	}

	@Override
	public List<Area> listarArea() {
		// TODO Auto-generated method stub
		return areamapper.listarArea();
	}

	@Override
	public String actualizarArea(@Valid Area area) {
		// TODO Auto-generated method stub
		return areamapper.actualizarArea(area);
	}

	@Override
	public String eliminarArea(@Valid Area area) {
		// TODO Auto-generated method stub
		return areamapper.eliminarArea(area);
	}

	@Override
	public Integer ListarAreaUsuario(Integer idarea) {
		// TODO Auto-generated method stub
		return areamapper.ListarAreaUsuario(idarea);
	}

	@Override
	public Page<Area> listarAreaPage(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Area> page = new Page<>();
		page.setContent(areamapper.listarAreaPage(pageable));
		page.setTotalElements(areamapper.countElements());
		return page;
	}

}
