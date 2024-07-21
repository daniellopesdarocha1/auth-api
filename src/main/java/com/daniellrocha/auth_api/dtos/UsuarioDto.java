package com.daniellrocha.auth_api.dtos;

import com.daniellrocha.auth_api.enums.RoleEnum;

public record UsuarioDto(
		String nome, 
		String login, 
		String senha, 
		RoleEnum role
) {
}
