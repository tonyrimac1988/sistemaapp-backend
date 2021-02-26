package com.sist.org.controller;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.org.dto.ImagenOperadorDto;
import com.sist.org.dto.OperadorDto;
import com.sist.org.dto.RespuestaBase;
import com.sist.org.service.IOperadorService;
import com.sist.org.util.Page;
import com.sist.org.util.Pageable;
import com.sist.org.util.ReporteRespuesta;

@RestController
@RequestMapping("/operadores")
public class OperadorController {


	@Autowired
	IOperadorService iOperadorService;

	@PostMapping(value = "/listaroperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Page<OperadorDto>>> listarOperador(@Validated @RequestBody Pageable pageable) {
		
		RespuestaBase<Page<OperadorDto>> respuesabase= new RespuestaBase<>();
		try {
			respuesabase.setEstado(HttpStatus.OK.toString());
			respuesabase.setMensaje("Respuesta OK");
			respuesabase.setData(Arrays.asList(iOperadorService.listarOperador(pageable)));
			return new ResponseEntity<RespuestaBase<Page<OperadorDto>>>( respuesabase, HttpStatus.OK);

		} catch (Exception e) {
			
			respuesabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuesabase.setMensaje("Hubo un error el método listarUsuario -> " + e.toString());
			respuesabase.setData(null);
			return new ResponseEntity<RespuestaBase<Page<OperadorDto>>>( respuesabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	 
	
	@PostMapping("/eliminaroperador")
	public ResponseEntity<RespuestaBase<Object>> EliminarOperador(@Valid @RequestBody int operador) {

		RespuestaBase<Object> respuestabase = new RespuestaBase<>(); 
		try {
			
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iOperadorService.eliminarOperador(operador));
			respuestabase.setData(null);
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
			
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el método eliminarOperador -> "+e.toString());
			respuestabase.setData(null);
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/reactivaroperador")
	public ResponseEntity<RespuestaBase<Object>> reactivaroperador(@Valid @RequestBody int operador) {

		RespuestaBase<Object> respuestabase = new RespuestaBase<>(); 
		
		try {
			
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje(iOperadorService.reactivaroperador(operador));
			respuestabase.setData(null);
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
			
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el método reactivaroperador -> "+e.toString());
			respuestabase.setData(null);
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PostMapping(value = "/modificarUsuarioOperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> modificarUsuarioOperador(@Validated @RequestBody OperadorDto operadorDto) {
 
		
		RespuestaBase<Object> respuestabase = new RespuestaBase<>() ;
	 
		try {
			
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(iOperadorService.modificarUsuarioOperador(operadorDto)));
			 
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
			
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el método modificarUsuarioOperador -> "+e.toString());
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value= "/insertaroperador", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBase<Object>> InsertarOperador(@Valid @RequestBody OperadorDto operador) {

		RespuestaBase<Object> respuestabase = new RespuestaBase<>() ;
		
		try {
			
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(iOperadorService.insertarOperador(operador)));
			
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.OK);
		} catch (Exception e) {
			
			respuestabase.setData(null);
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error en el método InsertarOperador -> "+e.toString());
						
			return new ResponseEntity<RespuestaBase<Object>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/generarReporte", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "text/plain")
	public ResponseEntity<RespuestaBase<ReporteRespuesta>> generarReporte(@RequestBody String tipoReporte) {
		
		
		RespuestaBase<ReporteRespuesta> respuestabase= new RespuestaBase<>();
		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(iOperadorService.generarReporte(tipoReporte)));
			
			return new ResponseEntity<RespuestaBase<ReporteRespuesta>>(respuestabase, HttpStatus.OK);
			
		} catch (Exception e) {
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error el método listarUsuario -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<ReporteRespuesta>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	
	@PostMapping( "/consultarimagenoperador")
	public ResponseEntity<RespuestaBase<ImagenOperadorDto>> consultarimagenoperador(@Valid @RequestBody int idoperador) {
		
		
		RespuestaBase<ImagenOperadorDto> respuestabase= new RespuestaBase<>();
		try {
			respuestabase.setEstado(HttpStatus.OK.toString());
			respuestabase.setMensaje("Respuesta OK");
			respuestabase.setData(Arrays.asList(iOperadorService.consultarimagenoperador(idoperador)));
			
			return new ResponseEntity<RespuestaBase<ImagenOperadorDto>>(respuestabase, HttpStatus.OK);
			
		} catch (Exception e) {
			respuestabase.setEstado(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			respuestabase.setMensaje("Hubo un error el método listarUsuario -> " + e.toString());
			respuestabase.setData(null);
			return new ResponseEntity<RespuestaBase<ImagenOperadorDto>>(respuestabase, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	
}
