package com.sist.org.service.impl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.sist.org.dto.ImagenOperadorDto;
import com.sist.org.dto.OperadorDto;
import com.sist.org.mapper.IOperadorMapper;
import com.sist.org.modelo.Operador;
import com.sist.org.service.IOperadorService;
import com.sist.org.util.IReportUtil;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;
import com.sist.org.util.ReporteRespuesta;

@Service
public class OperadorServiceImpl implements IOperadorService{



	private static final Logger log = LoggerFactory.getLogger(OperadorServiceImpl.class);
		
	
	@Autowired
	IOperadorMapper iOperadorMapper;
	
    @Autowired
    private IReportUtil reporte;
    
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
		//log.info(pageable.toString());
		if(pageable.getPalabraClave()== null || pageable.getPalabraClave()== "") {			
			/*consulta normal*/			
			page.setContent(iOperadorMapper.listarOperador(pageable));	
			page.setTotalElements(iOperadorMapper.countElements());
		}else {			
			/*consulta con filtro*/
			page.setContent(iOperadorMapper.buscaroperador(pageable));	
			page.setTotalElements(iOperadorMapper.countElements()); 			
		}			
		
		return page;
	}

	@Override
	public ReporteRespuesta generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
		byte[] data = null;
		
		ReporteRespuesta respuesta = new ReporteRespuesta();
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/menu/MenuReport.jasper").getFile();
							
			if(tipoReporte.equals("xlsx")) {				
				data = reporte.generarEXCEL(file, parametros);
				
			}else if (tipoReporte.equals("html")) {				
				data = reporte.generarHTML(file, parametros);
			
			}else if (tipoReporte.equals("pdf")) {
				data = reporte.generarPDF(file, parametros);
			}else {				
				log.info("FORMATO DE REPORTE DESCONOCIDO");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			log.info("ERRORRRRRRRRRR ");
		}
		
		respuesta.setReporte(data);
		
		return respuesta;
	}

	@Override
	public ImagenOperadorDto consultarimagenoperador(int idoperador) {
		// TODO Auto-generated method stub
		return iOperadorMapper.consultarimagenoperador(idoperador);
	}

 
}