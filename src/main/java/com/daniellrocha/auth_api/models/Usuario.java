package com.daniellrocha.auth_api.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.daniellrocha.auth_api.enums.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements UserDetails{

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private RoleEnum role;
		
	public Usuario() {
		
	}
			
	public Usuario(String nome, String login, String senha, RoleEnum role) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		if (this.role == RoleEnum.ADMIN) {
			return List.of(
					new SimpleGrantedAuthority("ROLE_ADMIN"),
					new SimpleGrantedAuthority("ROLE_USER")
			);
					
		}
		
		return List.of(
				new SimpleGrantedAuthority("ROLE_USER")
		);
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.nome;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public RoleEnum getRole() {
		return this.role;
	}
	
}
