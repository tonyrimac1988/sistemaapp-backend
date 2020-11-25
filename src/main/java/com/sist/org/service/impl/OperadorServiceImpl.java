package com.sist.org.service.impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.IOperadorMapper;
import com.sist.org.modelo.Operador;
import com.sist.org.service.IOperadorService;


@Service
public class OperadorServiceImpl implements IOperadorService{


	private static final Logger log = LoggerFactory.getLogger(OperadorServiceImpl.class);
		
	
	@Autowired
	IOperadorMapper personamapper;
	
	@Override
	public List<Operador> listarOperador() {
		// TODO Auto-generated method stub
		return personamapper.listarOperador() ;
	}

	@Override
	public String eliminarOperador(Operador operador) {
		// TODO Auto-generated method stub
		log.info("-------------------> "+operador.getNidoperador());
		return personamapper.eliminarOperador(operador);
	}

	@Override
	public String actualizarOperador(Operador operador) {
		// TODO Auto-generated method stub
		return personamapper.actualizarOperador(operador);
	}

	@Override
	public String insertarOperador(Operador operador) {
		// TODO Auto-generated method stub
		return personamapper.insertarOperador(operador);
	}


 
	

}