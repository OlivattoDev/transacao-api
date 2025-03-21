package com.matheusolivatto.transacao_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matheusolivatto.transacao_api.dtos.EstatisticaResponseDTO;
import com.matheusolivatto.transacao_api.services.EstatisticaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
	
	@Autowired
	private EstatisticaService estatisticaService;
	
	@GetMapping
	@Operation(description = "Endpoint responsável por buscar estatística de transação")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca efetuada com sucesso"),
			@ApiResponse(responseCode = "400", description = "Erro na busca de estatística de transação"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	
	public ResponseEntity<EstatisticaResponseDTO> buscarEstatistica(
			@RequestParam(value = "intervaloBusca", required = false,
			defaultValue = "60") Integer intervaloBusca) {
		return ResponseEntity.ok(estatisticaService.calcularEstatisticasTransacao(intervaloBusca));
	}
}
