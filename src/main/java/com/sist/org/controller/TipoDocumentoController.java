package com.sist.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.dto.RespuestaBase;
import com.sist.org.modelo.TipoDocumento;
import com.sist.org.service.ITipoDocumentoService;

@RestController
@RequestMapping("/tipodocumentos")
public class TipoDocumentoController {

	@Autowired
	ITipoDocumentoService iTipoDocumentoService; 
	
	@GetMapping(value = "/listartipodocumento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<TipoDocumento>> ListarTipoDocumento() {

		RespuestaBase<TipoDocumento> respuestabase = new RespuestaBase<>();
		
		try {							
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(iTipoDocumentoService.ListarTipoDocumento());			
			return new ResponseEntity<RespuestaBase<TipoDocumento>>(respuestabase, HttpStatus.OK);
			
		} catch (Exception e) {			
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el metodo ListarTipoDocumento -> "+e.toString());
			respuestabase.setData(null);			
			return new ResponseEntity<RespuestaBase<TipoDocumento>>(respuestabase , HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
 
	
}
