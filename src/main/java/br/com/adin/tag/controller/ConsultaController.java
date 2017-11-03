package br.com.adin.tag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("relatorio/consulta_tags")
public class ConsultaController {
	

	@GetMapping
	private ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/relatorio/ConsultarTAG");
		//mv.addObject(new Produto());
		return mv;
	}	
	

}
