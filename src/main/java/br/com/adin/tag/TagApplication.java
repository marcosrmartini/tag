package br.com.adin.tag;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TagApplication {
	
	private static final Logger log = Logger.getLogger(TagApplication.class);

	public static void main(String[] args) {
		log.info("Versão do sistema: " + Configuracoes.VERSAO);
		SpringApplication.run(TagApplication.class, args);
	}
}	
