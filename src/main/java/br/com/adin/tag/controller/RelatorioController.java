package br.com.adin.tag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("relatorio/relatorio_tags")
public class RelatorioController {
	
	@GetMapping
	private ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/relatorio/RelatorioTAG");
		//mv.addObject(new Produto());
		return mv;
	}	

}
