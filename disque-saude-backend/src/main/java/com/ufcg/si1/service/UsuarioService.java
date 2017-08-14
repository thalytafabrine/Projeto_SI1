package com.ufcg.si1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Usuario;
import com.ufcg.si1.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario) {
		
		List<Usuario> todosOsUsuarios = usuarioRepository.findAll();
		
		for (Usuario usuario2 : todosOsUsuarios) {
			if (usuario2.getEmail().equals(usuario.getEmail())) {
				return null;
			}
		}
		return usuarioRepository.save(usuario);
	}
	
	public Usuario logar(Usuario usuario) {
		
		List<Usuario> todosOsUsuarios = usuarioRepository.findAll();
		
		for (Usuario usuario2 : todosOsUsuarios) {
			if (usuario2.getEmail().equals(usuario.getEmail())) {
				if (usuario2.getSenha().equals(usuario.getSenha())) {
					return usuario2;
				}
			}
		}
		return null;
	}
}
