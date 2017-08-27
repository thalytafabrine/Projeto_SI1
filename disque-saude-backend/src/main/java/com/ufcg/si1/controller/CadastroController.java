package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.service.AdministradorService;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin
public class CadastroController {

	@Autowired
	private AdministradorService administradorService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Administrador> cadastrar(@RequestBody Administrador administrador) throws Exception {
		Administrador administradorCadastrado = administradorService.cadastrar(administrador);
		return new ResponseEntity<>(administradorCadastrado, HttpStatus.CREATED);
//		
//		try {
//			Administrador administradorCadastrado = administradorService.cadastrar(administrador);
//			return new ResponseEntity<>(administradorCadastrado, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
	}
}
