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
@RequestMapping("/administrador") //verificar se realmente precisa desse caminho (acho q n)
public class AdministradorController {
	
	/*decidir o q é melhor ser colocado aqui, acho q alguns metodos do queixaController precisar estar aqui,
	 * apenas n faz sentido estar lá.
	 */
}
