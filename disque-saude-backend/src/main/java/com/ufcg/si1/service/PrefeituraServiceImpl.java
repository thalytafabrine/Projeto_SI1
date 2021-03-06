package com.ufcg.si1.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.enums.SituacaoGeralQueixas;
import com.ufcg.si1.enums.SituacaoQueixa;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.PrefeituraCaos;
import com.ufcg.si1.model.prefeitura.PrefeituraExtra;
import com.ufcg.si1.model.prefeitura.PrefeituraNormal;
import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.repository.PrefeituraRepository;
import com.ufcg.si1.repository.QueixaRepository;

@Service("prefeituraService")
public class PrefeituraServiceImpl implements PrefeituraService {
	
	@Autowired
	QueixaRepository queixaRepository;
	
	@Autowired
	PrefeituraRepository prefeituraRepository;
	
	Prefeitura prefeitura;
	
	@PostConstruct
	public void inicializar() {
		this.prefeitura = new Prefeitura(new PrefeituraNormal());
		this.prefeituraRepository.save(prefeitura);
	}

	@Override
	public SituacaoGeralQueixas getSituacaoGeral() throws Exception {
		int qtdTotalQueixas = (int) this.queixaRepository.count();
		double numQueixasAbertas = (double) numQueixasAbertas();
		
		if (qtdTotalQueixas == 0 || numQueixasAbertas == 0)
			throw new Exception("Problema ao definir situacao geral.");
		return this.prefeitura.getSituacaoGeral(numQueixasAbertas, qtdTotalQueixas);
	}
	
	private int numQueixasAbertas() {
		List<Queixa> queixas = this.queixaRepository.findAll();
		int qtdQueixasAbertas = 0;
		
		for (Queixa queixa : queixas) {
			if (queixa.getStatus().getSituacaoQueixa().equals(SituacaoQueixa.ABERTA))
				qtdQueixasAbertas++;
		}
		
		return qtdQueixasAbertas;
	}

	@Override
	public Prefeitura modificaStatus(String situacao) {
		if(situacao.equals("Normal")){
			prefeitura.setSituacaoPrefeitura(new PrefeituraNormal());
		}else if(situacao.equals("Extra")){
			prefeitura.setSituacaoPrefeitura(new PrefeituraExtra());
			
		}else{
			prefeitura.setSituacaoPrefeitura(new PrefeituraCaos());
		}
		
		prefeituraRepository.save(prefeitura);
		
		return this.prefeitura;
	}

}
