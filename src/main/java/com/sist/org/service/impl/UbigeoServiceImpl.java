package com.sist.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.sist.org.mapper.IUbigeoMapper;
import com.sist.org.modelo.Ubigeo;
import com.sist.org.service.IUbigeoService;

@Service
public class UbigeoServiceImpl implements  IUbigeoService{

	
	@Autowired
	IUbigeoMapper  iUbigeoMapper;
	
	
	@Override
	public List<Ubigeo> listarDepartamento() {
		// TODO Auto-generated method stub
		return iUbigeoMapper.listarDepartamento() ;
	}

	@Override
	public List<Ubigeo> listarprovincia(String iddepartamento) {
		// TODO Auto-generated method stub
		return iUbigeoMapper.listarprovincia(iddepartamento);
	}

	@Override
	public List<Ubigeo> listardistrito(String idprovincia) {
		// TODO Auto-generated method stub
		return iUbigeoMapper.listardistrito(idprovincia);
	}
	

}
