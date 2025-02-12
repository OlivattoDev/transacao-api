package com.matheusolivatto.transacao_api.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusolivatto.transacao_api.dtos.EstatisticaResponseDTO;
import com.matheusolivatto.transacao_api.dtos.TransacaoRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticaService {

	@Autowired
	public TransacaoService transacaoService;
	
	public EstatisticaResponseDTO calcularEstatisticasTransacao(Integer intervaloBusca) {
		
		final Logger log = LoggerFactory.getLogger(EstatisticaService.class);
		log.info("Iniciada a busca de estatística de transação pelo período de tempo " + intervaloBusca);
		
		List<TransacaoRequestDTO> transacao = transacaoService.buscarTransacao(intervaloBusca);
		
		if(transacao.isEmpty()) {
			return new EstatisticaResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
		}
		
		DoubleSummaryStatistics estatisticasTransacao = transacao.stream()
				.mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();
		
		log.info("Estatística retornada com sucesso");
		
		simulateLatency();
		
		return new EstatisticaResponseDTO(estatisticasTransacao.getCount(),
				estatisticasTransacao.getSum(),
				estatisticasTransacao.getAverage(),
				estatisticasTransacao.getMin(),
				estatisticasTransacao.getMax());
	}

	private void simulateLatency() {
		try {
			long time = 1000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}
