package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Usuario;
import com.ufcg.si1.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		
		Usuario usuarioCadastrado = usuarioService.cadastrar(usuario);
		
		if (usuarioCadastrado == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Usuario> logar(@RequestBody Usuario usuario) {
		
		Usuario usuarioLogado = usuarioService.logar(usuario);
		
		if (usuarioLogado == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(usuarioLogado, HttpStatus.OK);
	}
}
