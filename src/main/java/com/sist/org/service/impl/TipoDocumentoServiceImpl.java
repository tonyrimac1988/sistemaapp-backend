package com.sist.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.org.mapper.ITipoDocumentoMapper;
import com.sist.org.modelo.TipoDocumento;
import com.sist.org.service.ITipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService{

	@Autowired
	ITipoDocumentoMapper iTipoDocumentoMapper; 
	
	@Override
	public List<TipoDocumento> ListarTipoDocumento() {
		// TODO Auto-generated method stub
		return iTipoDocumentoMapper.ListarTipoDocumento();
	}

  
	

}
