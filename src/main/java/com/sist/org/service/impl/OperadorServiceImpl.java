package com.sist.org.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.dto.OperadorDto;
import com.sist.org.mapper.IOperadorMapper;
import com.sist.org.modelo.Operador;
import com.sist.org.service.IOperadorService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;


@Service
public class OperadorServiceImpl implements IOperadorService{


	//private static final Logger log = LoggerFactory.getLogger(OperadorServiceImpl.class);
		
	
	@Autowired
	IOperadorMapper iOperadorMapper;
	
	@Override
	public String eliminarOperador(int operador) {
		// TODO Auto-generated method stub
		//log.info("-------------------> "+operador.getNidoperador());
		return iOperadorMapper.eliminarOperador(operador);
	}

	@Override
	public String actualizarOperador(Operador operador) {
		// TODO Auto-generated method stub
		return iOperadorMapper.actualizarOperador(operador);
	}

	@Override
	public String insertarOperador(OperadorDto operador) {
		// TODO Auto-generated method stub
		return iOperadorMapper.insertarOperador(operador);
	}

	@Override
	public String modificarUsuarioOperador(OperadorDto operadorDto) {
		// TODO Auto-generated method stub
		return iOperadorMapper.modificarUsuarioOperador(operadorDto);
	}

	@Override
	public Page<OperadorDto> listarOperador(Pageable pageable) {
		
		Page<OperadorDto> page = new Page<>();
		page.setContent(iOperadorMapper.listarOperador(pageable));	
		page.setTotalElements(iOperadorMapper.countElements());
		// TODO Auto-generated method stub
		
		return page;
	}


 
	

}