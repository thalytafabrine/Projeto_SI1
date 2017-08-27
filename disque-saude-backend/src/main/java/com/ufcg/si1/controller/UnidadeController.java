package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;

@RestController
@RequestMapping("/unidade")
@CrossOrigin
public class UnidadeController {

	private UnidadeSaudeService unidadeSaudeService;
	
	public UnidadeController(UnidadeSaudeService unidadeService) {
		this.unidadeSaudeService = unidadeService;
	}
	
	@RequestMapping(value = "/especialidade", method = RequestMethod.GET)
	public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@RequestBody Long id) {
		List<Especialidade> especialidades;
		try {
			especialidades = unidadeSaudeService.getEspecialidades(id);
			return new ResponseEntity<>(especialidades, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") Long id) {

		try {
			UnidadeSaude unidadeSaude = unidadeSaudeService.findById(id);
			return new ResponseEntity<>(unidadeSaude, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/geral/medicos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") Long id) {
		try {
			UnidadeSaude unidade = unidadeSaudeService.findById(id);
			double c = unidade.getNumFuncionarios() / unidade.getAtendimentosDiarios();
			return new ResponseEntity<>(new Double(c), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@RequestMapping(value="/busca", method= RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaudePorBairro(@RequestParam(value = "bairro", required = true) String bairro){
		UnidadeSaude unidadeSaude = unidadeSaudeService.findByBairro(bairro);
		return new ResponseEntity<UnidadeSaude>((UnidadeSaude) unidadeSaude, HttpStatus.OK);
	}

}
