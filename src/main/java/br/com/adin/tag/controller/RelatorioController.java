package br.com.adin.tag.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
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

	private static final Logger log = Logger.getLogger(RelatorioController.class);
	
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
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicio = new Date();
		Date dataTermino = new Date();
		try {
			dataInicio = format.parse(r.getInicio());
			dataTermino = format.parse(r.getTermino());

		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		mv.addObject("tags", trackers.listarPorPeriodo(r.getCustomer().getId(), dataInicio, dataTermino));
		return mv;
		
	}

}
