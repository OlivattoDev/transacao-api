package com.matheusolivatto.transacao_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusolivatto.transacao_api.dtos.TransacaoRequestDTO;
import com.matheusolivatto.transacao_api.services.TransacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;

	@PostMapping
	@Operation(description = "Endpoint responsável por adicionar transação")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Transação gravada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Campos não atendem os requisitos da transação"),
			@ApiResponse(responseCode = "400", description = "Erro de requisição"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	
	public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto) {
		transacaoService.adicionarTransacao(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping
	@Operation(description = "Endpoint responsável por deletar transação")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Transação deletada com sucesso"),
			@ApiResponse(responseCode = "400", description = "Erro de requisição"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor")
	})
	
	public ResponseEntity<Void> deletarTransacoes() {
		transacaoService.limparTransacao();
		return ResponseEntity.ok().build();
	}
}
