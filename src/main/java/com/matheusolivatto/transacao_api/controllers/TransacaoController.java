package com.matheusolivatto.transacao_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusolivatto.transacao_api.dtos.TransacaoRequestDTO;
import com.matheusolivatto.transacao_api.services.TransacaoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	private TransacaoService transacaoService;

	@PostMapping
	public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto) {
		transacaoService.adicionarTransacao(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletarTransacoes() {
		transacaoService.limparTransacao();
		return ResponseEntity.ok().build();
	}
}
