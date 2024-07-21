package com.daniellrocha.auth_api.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.daniellrocha.auth_api.dtos.AuthDto;

public interface AutenticacaoService extends UserDetailsService{

	public String obterToken(AuthDto authDto);
	
	public String validaTokenJwt(String token);
	
}
