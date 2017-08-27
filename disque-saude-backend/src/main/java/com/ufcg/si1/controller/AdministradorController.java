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

import com.ufcg.si1.enums.SituacaoGeralQueixas;
import com.ufcg.si1.model.prefeitura.SituacaoPrefeitura;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.service.AdministradorService;
import com.ufcg.si1.service.PrefeituraService;
import com.ufcg.si1.service.QueixaService;

@RestController
@CrossOrigin
public class AdministradorController {
	
	@Autowired
	AdministradorService administradorService;
	
	@Autowired
	QueixaService queixaService;
	
	@Autowired
	PrefeituraService prefeituraService;
	
	@RequestMapping(value = "/statusQueixa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Queixa> modificaStatusDaQueixa(@PathVariable("id") Long id, @RequestBody String statusQueixa){
		try {
			Queixa queixa = queixaService.modificaStatusDaQueixa(id, statusQueixa);
			return new ResponseEntity<>(queixa, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/comentarioQueixa/", method = RequestMethod.POST)
	public ResponseEntity<Queixa> addComentarioNaQueixa(@RequestBody Queixa queixa ){
		Queixa queixaModificada = queixaService.adicionarComentario(queixa.getId(), queixa.getComentario());
		return new ResponseEntity<Queixa>(queixaModificada, HttpStatus.OK);
	}

	@RequestMapping(value = "/geral/situacao/", method = RequestMethod.GET)
	public ResponseEntity<SituacaoGeralQueixas> getSituacaoGeralQueixas() {
		try {
			SituacaoGeralQueixas situacao = this.prefeituraService.getSituacaoGeral();
			return new ResponseEntity<SituacaoGeralQueixas>(situacao, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/situacaoPrefeitura/", method = RequestMethod.PUT)
	public ResponseEntity<SituacaoPrefeitura> modificaSituacaoPrefeitura(@RequestBody SituacaoPrefeitura situacaoPrefeitura ){
		this.prefeituraService.setSituacaoPrefeitura(situacaoPrefeitura);
		return new ResponseEntity<>(situacaoPrefeitura, HttpStatus.OK);
	}
	
	/*decidir o q é melhor ser colocado aqui, acho q alguns metodos do queixaController precisar estar aqui,
	 * apenas n faz sentido estar lá.
	 */
}
