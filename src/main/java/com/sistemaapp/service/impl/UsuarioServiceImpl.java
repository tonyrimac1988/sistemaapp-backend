package com.sistemaapp.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sistemaapp._util.IReportUtil;
import com.sistemaapp.model.Usuario;
import com.sistemaapp.repo.IUsuarioRepo;
import com.sistemaapp.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private IUsuarioRepo iusuarioRepo;
	
    @Autowired
    private IReportUtil reporte;

	@Override
	public Usuario registrar(Usuario obj) {
		// TODO Auto-generated method stub
		return iusuarioRepo.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		// TODO Auto-generated method stub
		return iusuarioRepo.save(obj);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return iusuarioRepo.findAll(Sort.by("nIdUsuario").descending());
	}

	@Override
	public Usuario listarPorId(Integer v) {
		// TODO Auto-generated method stub
		Optional<Usuario> usu = iusuarioRepo.findById(v);
		return usu.isPresent() ? usu.get() : new Usuario();
	}

	@Override
	public void eliminar(Integer v) {
		// TODO Auto-generated method stub
		iusuarioRepo.deleteById(v);
	}

	@Override
	public Page<Usuario> listarPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		Pageable pageSortedBy = PageRequest.of(pageable.getPageNumber() , pageable.getPageSize(), Sort.by("nIdUsuario").descending());
		return iusuarioRepo.findAll(pageSortedBy);
	}

	@Override
	public byte[] generarReporte(String tipoReporte) {
		// TODO Auto-generated method stub
		byte[] data = null;
		
		try { 
			Map<String, Object> parametros = new HashMap<>();				
			File file = new ClassPathResource("/reportes/usuario/UsuarioReport.jasper").getFile();
							
			if(tipoReporte.equals("xlsx")) {
				
				log.info("xlsx");
				data = reporte.generarEXCEL(file, parametros);
				
			}else if (tipoReporte.equals("html")) {
				
				log.info("html");
				data = reporte.generarHTML(file, parametros);
			
			}else if (tipoReporte.equals("pdf")) {
				
				log.info("pdf");
				data = reporte.generarPDF(file, parametros);
				
			}else {
				
				log.info("FORMATO DE REPORTE DESCONOCIDO");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			log.info("ERRORRRRRRRRRR ");
		}
		return data;
	}

}
