package com.matheusolivatto.transacao_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matheusolivatto.transacao_api.dtos.EstatisticaResponseDTO;
import com.matheusolivatto.transacao_api.dtos.TransacaoRequestDTO;
import com.matheusolivatto.transacao_api.services.EstatisticaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
	
	private EstatisticaService estatisticaService;
	
	public ResponseEntity<EstatisticaResponseDTO> buscarEstatistica(
			@RequestParam(value = "intervaloBusca", required = false,
			defaultValue = "60") Integer intervaloBusca) {
		return ResponseEntity.ok(estatisticaService.calcularEstatisticasTransacao(intervaloBusca));
	}

}
