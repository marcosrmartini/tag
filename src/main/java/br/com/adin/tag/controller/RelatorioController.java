package br.com.adin.tag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.adin.tag.model.relatorios.RelatorioTAG;
import br.com.adin.tag.repository.CustomersRepository;
import br.com.adin.tag.repository.TrackerConfigurationRepository;

@Controller
@RequestMapping("relatorio/relatorio_tags")
public class RelatorioController {
	
	@Autowired
	private CustomersRepository customers;
	
	@Autowired
	private TrackerConfigurationRepository trackers;

	@GetMapping
	private ModelAndView abrir(){
		ModelAndView mv = new ModelAndView("/relatorio/RelatorioTAG");
		mv.addObject(new RelatorioTAG());
		mv.addObject("customers", customers.findAll());
		return mv;
	}	
	
	@PostMapping
	private ModelAndView pesquisar(RelatorioTAG r){
		ModelAndView mv = new ModelAndView("/relatorio/RelatorioTAG");
		mv.addObject("customers", customers.findAll());
		mv.addObject("tags", trackers.listarPorPeriodo(r.getCustomer().getId(), r.getInicio(), r.getTermino()));
		return mv;
		
	}

}
