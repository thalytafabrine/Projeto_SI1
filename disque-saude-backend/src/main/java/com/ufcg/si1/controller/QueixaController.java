package com.ufcg.si1.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.enums.SituacaoQueixa;
import com.ufcg.si1.model.Prefeitura;
import com.ufcg.si1.model.PrefeituraNormal;
import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.Situacao;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.QueixaServiceImpl;
import com.ufcg.si1.util.CustomErrorType;

import exceptions.ObjetoInvalidoException;

@RestController
@RequestMapping("/queixa")
@CrossOrigin
public class QueixaController {

	private QueixaService queixaService = new QueixaServiceImpl();
	private Prefeitura prefeitura = new PrefeituraNormal();
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<Queixa>> listAllQueixas() {
        List<Queixa> queixas = queixaService.findAllQueixas();

        if (queixas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa, UriComponentsBuilder ucBuilder) {

        try {
            queixa.abrir();
        } catch (ObjetoInvalidoException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        queixaService.saveQueixa(queixa);

        return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarQueixa(@PathVariable("id") Integer id) {

        Queixa queixa = queixaService.findById(id);
        if (queixa == null) {
            return new ResponseEntity<>(new CustomErrorType("Queixa com id " + id + " não encontrada."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Queixa>(queixa, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizaQueixa(@PathVariable("id") Integer id, @RequestBody Queixa queixa) throws Exception {

    	try {
    		queixaService.updateQueixa(id, queixa);
    	} catch (Exception e) {
    		return new ResponseEntity<>(new CustomErrorType("Impossível atualizar. Queixa com id " + id + " não encontrada"),
 					HttpStatus.NOT_FOUND);
    	}
    	
        return new ResponseEntity<Queixa>(HttpStatus.OK);
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQueixa(@PathVariable("id") Integer id) throws Exception {
    	try {
  			queixaService.deleteQueixaById(id);
  			} catch (Exception e) {
 			return new ResponseEntity<>(new CustomErrorType("Impossível excluir. Queixa com id " + id + " não encontrada."),
 					HttpStatus.NOT_FOUND);
 		}
    	
 		return new ResponseEntity<Queixa>(HttpStatus.OK);
    }


    @RequestMapping(value = "/fechar", method = RequestMethod.POST)
    public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) throws Exception {
    	Integer id = queixaAFechar.getId();
    	try {
 			queixaService.fecharQueixa(queixaAFechar);
 		} catch (Exception e) {
 			return new ResponseEntity<>(new CustomErrorType("Não é possível fechar. Queixa com id " + id + " não encontrada."),
 					HttpStatus.NOT_FOUND);
 		}
         
 		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
    }
    
    private double numeroQueixasAbertas() {
        int contador = 0;
        List<Queixa> queixas = queixaService.findAllQueixas();
        for (Queixa queixa : queixas) {
            if (queixa.getSituacao() == SituacaoQueixa.ABERTA)
                contador++;
        }
        return contador;
    }
    
    @RequestMapping(value = "/geral/situacao", method = RequestMethod.GET)
    public Situacao getSituacaoGeralQueixas() {
        // dependendo da situacao da prefeitura, o criterio de avaliacao muda
        // se normal, mais de 20% abertas eh ruim, mais de 10 eh regular
        // se extra, mais de 10% abertas eh ruim, mais de 5% eh regular
    	return this.prefeitura.getSituacaoPrefeitura().getSituacaoGeral(numeroQueixasAbertas(), queixaService.size());

    }
}
