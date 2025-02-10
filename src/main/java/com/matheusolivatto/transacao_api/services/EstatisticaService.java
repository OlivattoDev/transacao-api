package com.matheusolivatto.transacao_api.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matheusolivatto.transacao_api.dtos.EstatisticaResponseDTO;
import com.matheusolivatto.transacao_api.dtos.TransacaoRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstatisticaService {

	public TransacaoService transacaoService;
	
	public EstatisticaResponseDTO calcularEstatisticasTransacao(Integer intervaloBusca) {
		List<TransacaoRequestDTO> transacao = transacaoService.buscarTransacao(intervaloBusca);
		
		DoubleSummaryStatistics estatisticasTransacao = transacao.stream()
				.mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();
		
		return new EstatisticaResponseDTO(estatisticasTransacao.getCount(),
				estatisticasTransacao.getSum(),
				estatisticasTransacao.getAverage(),
				estatisticasTransacao.getMin(),
				estatisticasTransacao.getMax());
	}
}
