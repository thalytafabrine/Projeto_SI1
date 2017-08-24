package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.util.CustomErrorType;

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
    	} catch (Exception e) {
    		return new ResponseEntity<>(new CustomErrorType("Impossível atualizar. Queixa com id " + id + " não encontrada"),
 					HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<Queixa>(HttpStatus.OK);
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQueixa(@PathVariable("id") Long id) throws Exception {
    	try {
  			queixaService.excluirQueixaPorId(id);
  		} catch (Exception e) {
 			return new ResponseEntity<>(new CustomErrorType("Impossível excluir. Queixa com id " + id + " não encontrada."),
 					HttpStatus.NOT_FOUND);
 		}
 		return new ResponseEntity<Queixa>(HttpStatus.OK);
    }


  /*  @RequestMapping(value = "/fechar", method = RequestMethod.POST)
    public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) throws Exception {
    	Long id = queixaAFechar.getId();
    	try {
 			queixaService.fecharQueixa(queixaAFechar);
 		} catch (Exception e) {
 			return new ResponseEntity<>(new CustomErrorType("Impossível fechar. Queixa com id " + id + " não encontrada."),
 					HttpStatus.NOT_FOUND);
 		}
 		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
    }
    */
}