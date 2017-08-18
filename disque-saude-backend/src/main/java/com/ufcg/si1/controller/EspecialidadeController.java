package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.service.EspecialidadeService;
import com.ufcg.si1.util.CustomErrorType;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin

public class EspecialidadeController {

	@Autowired
	private EspecialidadeService especialidadeService;
	
	public EspecialidadeController(EspecialidadeService especialidadeService) {
		this.especialidadeService = especialidadeService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Especialidade> addEspecialidade(@RequestBody Especialidade esp) {
		Especialidade especialidade = especialidadeService.addEspecialidade(esp);
		return new ResponseEntity<Especialidade>(especialidade, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarEspecialidade(@PathVariable("id") Long id) {
		try {
			Especialidade especialidade = especialidadeService.getEspecialidade(id);
			return new ResponseEntity<Especialidade>(especialidade, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomErrorType("Especialidade with id " + id
					+ " not found"), HttpStatus.NOT_FOUND);
		}
	}
	
}
