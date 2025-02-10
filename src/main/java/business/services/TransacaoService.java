package business.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import controllers.dtos.TransacaoRequestDTO;
import infrastructure.exceptions.UnprocessableEntity;
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
			throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");
		}
	}
	
}
