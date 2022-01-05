package com.ssanz.corunet;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ssanz.corunet.vo.EntradaDatosVO;

@SpringBootTest
@AutoConfigureMockMvc
class SergioSanzCorunetApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testPrices() throws Exception {
				
		//Mismos valores para todos los tests
		Integer idCadena = 1;
		Integer idProducto = 35455;
		
		//Test1 
		getResultTest(new EntradaDatosVO(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 10:00:00"), 
				idProducto, 
				idCadena));
		
		//Test2
		getResultTest(new EntradaDatosVO(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 16:00:00"), 
				idProducto, 
				idCadena));
	
		//Test3		
		getResultTest(new EntradaDatosVO(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 21:00:00"), 
				idProducto, 
				idCadena));
		
		//Test4	
		getResultTest(new EntradaDatosVO(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 10:00:00"), 
				idProducto, 
				idCadena));
		
		//Test5
		getResultTest(new EntradaDatosVO(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-16 21:00:00"), 
				idProducto, 
				idCadena));

	
	}
	
	private String getResultTest(EntradaDatosVO entrada) {
		try {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(entrada);
			
			return mvc.perform(MockMvcRequestBuilders.get("/busqueda")
					.contentType(MediaType.APPLICATION_JSON)
					.content(json))
					.andExpect(status().isOk())
					.andDo(print())
					.andReturn()
					.getResponse()
					.getContentAsString();
		}catch(Exception e) {
			return "Error en el test: " + e.getMessage();
		}
	}

}
