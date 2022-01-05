package com.ssanz.corunet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ssanz.corunet.vo.EntradaDatosVO;

@Controller
public class MainController{
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("formularioEntrada", new EntradaDatosVO());
		return "main";
	}

}
