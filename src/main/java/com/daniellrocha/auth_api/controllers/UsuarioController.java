package com.daniellrocha.auth_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniellrocha.auth_api.dtos.UsuarioDto;
import com.daniellrocha.auth_api.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto) {
		return usuarioService.salvar(usuarioDto);
	}
	
	@GetMapping("/admin")
	private String getAdmin() {
		return "permissão de administrador";
	}
	
	@GetMapping("/user")
	private String getUser() {
		return "permissão de usuário";
	}
	
	
}
