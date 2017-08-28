package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;

import exceptions.ObjetoInvalidoException;

@RestController
@RequestMapping("/queixa")
@CrossOrigin
public class QueixaController {

	@Autowired
	private QueixaService queixaService;
	
	public QueixaController(QueixaService queixaService) {
		this.queixaService = queixaService;
	}

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Queixa> abrirQueixa(@RequestBody Queixa queixa) throws Exception {

        try {
        	queixaService.salvarQueixa(queixa);
        	return new ResponseEntity<Queixa>(queixa,HttpStatus.CREATED);
        } catch (ObjetoInvalidoException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarQueixa(@PathVariable("id") Long id) {
    	try {
    		Queixa queixa = queixaService.procurarPorId(id);
    		return new ResponseEntity<Queixa>(queixa, HttpStatus.OK);
    	}
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizaQueixa(@PathVariable("id") Long id, @RequestBody Queixa queixa) throws Exception {
    	try {
    		queixaService.atualizarQueixa(id, queixa);
    		return new ResponseEntity<Queixa>(HttpStatus.OK);
    	} catch (Exception e) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQueixa(@PathVariable("id") Long id) throws Exception {
    	try {
  			queixaService.excluirQueixaPorId(id);
  			return new ResponseEntity<Queixa>(HttpStatus.OK);
  		} catch (Exception e) {
 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  		}
    }
}