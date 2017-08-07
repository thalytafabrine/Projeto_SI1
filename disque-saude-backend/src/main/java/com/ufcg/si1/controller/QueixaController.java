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

import com.ufcg.si1.enums.Situacao;
import com.ufcg.si1.model.PrefeituraNormal;
import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.SituacaoPrefeitura;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.service.QueixaServiceImpl;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import exceptions.ObjetoInvalidoException;

@RestController
@RequestMapping("/queixa")
@CrossOrigin
public class QueixaController {

	private QueixaService queixaService = new QueixaServiceImpl();
	private SituacaoPrefeitura situacaoAtualPrefeitura = new PrefeituraNormal();
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<Queixa>> listAllUsers() {
        List<Queixa> queixas = queixaService.findAllQueixas();

        if (queixas.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
    }
	
	   // -------------------Abrir uma Queixa-------------------------------------------

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa, UriComponentsBuilder ucBuilder) {

        try {
            queixa.abrir();
        } catch (ObjetoInvalidoException e) {
            return new ResponseEntity<List>(HttpStatus.BAD_REQUEST);
        }
        queixaService.saveQueixa(queixa);

       // HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/api/queixa/{id}").buildAndExpand(queixa.getId()).toUri());

        return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarQueixa(@PathVariable("id") long id) {

        Queixa q = queixaService.findById(id);
        if (q == null) {
            return new ResponseEntity(new CustomErrorType("Queixa with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Queixa>(q, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateQueixa(@PathVariable("id") long id, @RequestBody Queixa queixa) {

        Queixa currentQueixa = queixaService.findById(id);

        if (currentQueixa == null) {
            return new ResponseEntity(new CustomErrorType("Unable to upate. Queixa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentQueixa.setDescricao(queixa.getDescricao());
        currentQueixa.setComentario(queixa.getComentario());

        queixaService.updateQueixa(currentQueixa);
        return new ResponseEntity<Queixa>(currentQueixa, HttpStatus.OK);
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteQueixa(@PathVariable("id") long id) {

        Queixa queixa = queixaService.findById(id);
        if (queixa == null) {
            return new ResponseEntity(new CustomErrorType("Unable to delete. Queixa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        queixaService.deleteQueixaById(id);
        return new ResponseEntity<Queixa>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/fechar", method = RequestMethod.POST)
    public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) {
        queixaAFechar.situacao = Situacao.FECHADA;
        queixaService.updateQueixa(queixaAFechar);
        return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
    }
    
    private double numeroQueixasAbertas() {
        int contador = 0;
        Iterator<Queixa> it = queixaService.getIterator();
        for (Iterator<Queixa> it1 = it; it1.hasNext(); ) {
            Queixa q = it1.next();
            if (q.getSituacao() == Situacao.ABERTA)
                contador++;
        }

        return contador;
    }
    
    @RequestMapping(value = "/geral/situacao", method = RequestMethod.GET)
    public ResponseEntity<?> getSituacaoGeralQueixas() {

        // dependendo da situacao da prefeitura, o criterio de avaliacao muda
        // se normal, mais de 20% abertas eh ruim, mais de 10 eh regular
        // se extra, mais de 10% abertas eh ruim, mais de 5% eh regular
        ObjWrapper<Integer> obj = this.situacaoAtualPrefeitura.getSituacaoGeral((double) numeroQueixasAbertas(), queixaService.size());

        //situacao retornada
        //0: RUIM
        //1: REGULAR
        //2: BOM
        return new ResponseEntity<ObjWrapper<Integer>>(obj, HttpStatus.OK);
    }
}
