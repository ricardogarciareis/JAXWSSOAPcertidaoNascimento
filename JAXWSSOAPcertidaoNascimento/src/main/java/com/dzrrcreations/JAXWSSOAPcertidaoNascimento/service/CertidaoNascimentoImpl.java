package com.dzrrcreations.JAXWSSOAPcertidaoNascimento.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.jws.WebService;

/**
 * Service Implementation Bean (SIB)
 */
@WebService(endpointInterface = "com.dzrrcreations.JAXWSSOAPcertidaoNascimento.service.CertidaoNascimento")
public class CertidaoNascimentoImpl implements CertidaoNascimento {

	private final static Logger LOGGER = LoggerFactory.getLogger(CertidaoNascimentoImpl.class);

	@Override
	public int calcularIdade(String idade) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int idadeCalculada = 0;
		try {
			Calendar dataNascimento = Calendar.getInstance();
			Date idadeDate = sdf.parse(idade);
			dataNascimento.setTime(idadeDate);
			Calendar hoje = Calendar.getInstance();
			idadeCalculada = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
			// se ainda não chegou o aniversário
			if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
				idadeCalculada--;
			} else {
				if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
					idadeCalculada--;
				}
			}
		} catch (ParseException e) {
			LOGGER.error("Erro no método calcularIdade() : {}", e);
		}
		return idadeCalculada;
	}

	@Override
	public String diaSemanaNascimento(String idade) {
		String dias[] = {"Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"};
		int dia = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Calendar dataNascimento = Calendar.getInstance();
			Date idadeDate = sdf.parse(idade);
			dataNascimento.setTime(idadeDate);
			dia = dataNascimento.get(Calendar.DAY_OF_WEEK);
		} catch (ParseException e) {
			LOGGER.error("Erro no método diaSemanaNascimento() : {}", e);
		}
		return dias[dia - 1];
	}

}
