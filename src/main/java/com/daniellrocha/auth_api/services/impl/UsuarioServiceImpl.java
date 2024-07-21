package com.daniellrocha.auth_api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daniellrocha.auth_api.dtos.UsuarioDto;
import com.daniellrocha.auth_api.models.Usuario;
import com.daniellrocha.auth_api.repositores.UsuarioRepository;
import com.daniellrocha.auth_api.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UsuarioDto salvar(UsuarioDto usuarioDto) {
		
		Usuario usuarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());
		
		if (usuarioJaExiste != null) {
			throw new RuntimeException("Usuário já existe!");
		}
		
		var passwordHash = passwordEncoder.encode(usuarioDto.senha());
		
		Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.login(), passwordHash, usuarioDto.role());
		
		Usuario novoUsuario = usuarioRepository.save(entity);
		
		return new UsuarioDto(novoUsuario.getUsername(), novoUsuario.getLogin(), novoUsuario.getPassword(), novoUsuario.getRole());
	}
	
}
