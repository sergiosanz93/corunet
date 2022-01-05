package com.ssanz.corunet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ssanz.corunet.entity.Prices;
import com.ssanz.corunet.iservice.IPricesService;
import com.ssanz.corunet.vo.EntradaDatosVO;
import com.ssanz.corunet.vo.SalidaDatosVO;

@RestController
public class MainRestController {
	
	
	@Autowired
    MessageSource messageSource;
	
	@Autowired
	IPricesService pricesService;

	@RequestMapping(value="/busqueda", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<SalidaDatosVO>>  postBusqueda(@RequestBody EntradaDatosVO entrada) {
		List<Prices> lstPrecios = new ArrayList<Prices>();
		List<SalidaDatosVO> retorno = new ArrayList<SalidaDatosVO>();
		lstPrecios = pricesService.findDatosPricesBrand(entrada.getFechaAplicacion(), entrada.getIdCadena(), entrada.getIdProducto());
		retorno = pricesService.formatLstPricesToJson(lstPrecios);
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}
	
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handle(HttpMessageNotReadableException e) {
		String message = messageSource.getMessage("error.badrequest.json", null, Locale.getDefault()) 
				+ "\nMensaje de error: "
				+ e.getMessage();
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
}
