package br.com.adin.tag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cadastro/gerar_tag")
public class TagController {

	
	@GetMapping
	private ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/cadastro/GerarTAG");
		//mv.addObject(new Produto());
		return mv;
	}
	
}
