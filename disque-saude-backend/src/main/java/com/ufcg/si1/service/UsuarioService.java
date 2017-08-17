package com.ufcg.si1.service;

import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Usuario;

@Service
public interface UsuarioService {
	
	public Usuario cadastrar(Usuario usuario);
	
	public Usuario logar(Usuario usuario);
	
}
