package com.daniellrocha.auth_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daniellrocha.auth_api.dtos.AuthDto;
import com.daniellrocha.auth_api.services.AutenticacaoService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AutenticacaoService AutenticacaoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public String auth(@RequestBody AuthDto authDto) {
		
		var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.senha());
		authenticationManager.authenticate(usuarioAutenticationToken);
		
		return AutenticacaoService.obterToken(authDto);
	}
	
}
