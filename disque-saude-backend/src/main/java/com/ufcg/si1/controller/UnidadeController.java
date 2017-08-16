package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import br.edu.ufcg.Hospital;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/unidade")
@CrossOrigin
public class UnidadeController {

	private UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> incluirUnidadeSaude(@RequestBody UnidadeSaude unidadeSaude, UriComponentsBuilder ucBuilder) {

		try {
			unidadeSaudeService.insere(unidadeSaude);
		} catch (Rep e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (ObjetoJaExistenteException e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(unidadeSaude.getCodigo()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/especialidade", method = RequestMethod.GET)
	public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@RequestBody int codigoUnidadeSaude) {

		Object us = null;
		try {
			us = unidadeSaudeService.procura(codigoUnidadeSaude);
		} catch (Rep e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (us instanceof UnidadeSaude){
			UnidadeSaude us1 = (UnidadeSaude) us;
			return new ResponseEntity<>(us1.getEspecialidades(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUnidades() {
		List<UnidadeSaude> unidades = unidadeSaudeService.getAll();
		if (unidades.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else{
			return new ResponseEntity<>(unidades, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/unidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) {

		Object unidadeSaude = unidadeSaudeService.findById(id);
		if (unidadeSaude == null) {
			return new ResponseEntity<>(new CustomErrorType("Unidade with id " + id
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(unidadeSaude, HttpStatus.OK);
	}


	@RequestMapping(value = "/geral/medicos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {

		Object unidade = unidadeSaudeService.findById(id);

		if(unidade == null){
			return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);
		}

		double c = 0.0;
		if (unidade instanceof PostoSaude)
			c = ((PostoSaude) unidade).getAtendentes()
			/ ((PostoSaude) unidade).getTaxaDiariaAtendimentos();
		else if (unidade instanceof Hospital){
			c = ((Hospital) unidade).getNumeroMedicos()
					/ ((Hospital) unidade).getNumeroPacientesDia();
		}
		return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(new Double(c)), HttpStatus.OK);
	}

	@RequestMapping(value="/busca", method= RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaudePorBairro(@RequestParam(value = "bairro", required = true) String bairro){
		Object unidadeSaude = unidadeSaudeService.findByBairro(bairro);
		if (unidadeSaude == null && !(unidadeSaude instanceof UnidadeSaude)) {
			return new ResponseEntity<>(new CustomErrorType("Unidade with bairro " + bairro
					+ " not found"), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UnidadeSaude>((UnidadeSaude) unidadeSaude, HttpStatus.OK);
	}

}
