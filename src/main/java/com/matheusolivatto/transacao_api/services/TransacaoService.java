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
	
	final Logger log = LoggerFactory.getLogger(TransacaoService.class);
	
	public void adicionarTransacao(TransacaoRequestDTO dto) {
		
		log.info("Iniciado o processamento de gravar transação " + dto);
		
		if(dto.dataHora().isAfter(OffsetDateTime.now())) {
			log.error("Data e hora maiores que a data atual");
			throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");
		}
		
		if(dto.valor() < 0) {
			log.error("O valor não pode ser menor que 0");
			throw new UnprocessableEntity("O valor não pode ser menor que 0");
		}
		
		listaTransacao.add(dto);
		log.info("transação adicionada com sucesso");
	}
	
	public void limparTransacao() {
		log.info("Iniciado processamente para deletar transação");
		listaTransacao.clear();
		log.info("transação deletada com sucesso");
	}
	
	public List<TransacaoRequestDTO> buscarTransacao(Integer intervaloBusca) {
		log.info("Iniciada busca de transação por tempo " + intervaloBusca);
		OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
		
		log.info("Retorno de transação com sucesso");
		return listaTransacao.stream().filter(transacao -> transacao.dataHora()
				.isAfter(dataHoraIntervalo)).toList();
	}
}
