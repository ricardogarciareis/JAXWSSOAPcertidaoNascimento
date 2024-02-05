package com.dzrrcreations.JAXWSSOAPcertidaoNascimento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dzrrcreations.JAXWSSOAPcertidaoNascimento.service.CertidaoNascimentoImpl;

import jakarta.xml.ws.Endpoint;

@SpringBootApplication
public class JaxwssoaPcertidaoNascimentoApplication {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(JaxwssoaPcertidaoNascimentoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JaxwssoaPcertidaoNascimentoApplication.class, args);
		
		LOGGER.info("SERVIÇO CERTIDÃO DE NASCIMENTO inicializado...");
		CertidaoNascimentoImpl certidaoNascimento = new CertidaoNascimentoImpl();
		Endpoint.publish("http://localhost:8085/service/certidao", certidaoNascimento);
		LOGGER.info("Serviço publicado com sucesso");
	}

}
