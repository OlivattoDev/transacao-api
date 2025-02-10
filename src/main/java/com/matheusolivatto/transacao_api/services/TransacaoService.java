package com.matheusolivatto.transacao_api.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matheusolivatto.transacao_api.dtos.TransacaoRequestDTO;
import com.matheusolivatto.transacao_api.infrastructure.exceptions.UnprocessableEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

	private final List<TransacaoRequestDTO> listaTransacao = new ArrayList<>();
	
	public void adicionarTransacao(TransacaoRequestDTO dto) {
		
		final Logger log = LoggerFactory.getLogger(TransacaoService.class);
		log.info("Iniciado o processamento de gravar transação");
		
		if(dto.dataHora().isAfter(OffsetDateTime.now())) {
			log.error("Data e hora maiores que a data atual");
			throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");
		}
		if(dto.valor() < 0) {
			log.error("O valor não pode ser menor que 0");
			throw new UnprocessableEntity("O valor não pode ser menor que 0");
		}
		
		listaTransacao.add(dto);
	}
	
	public void limparTransacao() {
		listaTransacao.clear();
	}
	
	public List<TransacaoRequestDTO> buscarTransacao(Integer intervaloBusca) {
		OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
		
		return listaTransacao.stream().filter(transacao -> transacao.dataHora()
				.isAfter(dataHoraIntervalo)).toList();
	}
}
