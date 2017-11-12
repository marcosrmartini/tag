package br.com.adin.tag;

import org.apache.log4j.Logger;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	
	private static final Logger log = Logger.getLogger(TagApplication.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		log.info("Versão do sistema: " + Configuracoes.VERSAO);
		return application.sources(TagApplication.class);
	}

}
