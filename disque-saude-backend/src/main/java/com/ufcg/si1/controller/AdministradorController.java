package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired
	private AdministradorService administradorService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Administrador> cadastrar(@RequestBody Administrador administrador) {
		
		Administrador administradorCadastrado = administradorService.cadastrar(administrador);
		
		if (administradorCadastrado == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(administradorCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Administrador> logar(@RequestBody Administrador administrador) {
		
		Administrador administradorLogado = administradorService.logar(administrador);
		
		if (administradorLogado == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(administradorLogado, HttpStatus.OK);
	}
}
