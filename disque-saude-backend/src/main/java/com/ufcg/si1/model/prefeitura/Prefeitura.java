package com.ufcg.si1.model.prefeitura;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ufcg.si1.enums.SituacaoGeralQueixas;

@Entity
public class Prefeitura {
	
	@Id
	@GeneratedValue
	Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SituacaoPrefeitura situacaoPrefeitura;

	public Prefeitura(SituacaoPrefeitura situacao) {
		this.situacaoPrefeitura = situacao;
	}
	
	public SituacaoGeralQueixas getSituacaoGeral(double numQueixasAbertas, int qtdTotalQueixas) {
		return this.situacaoPrefeitura.getSituacaoGeral(numQueixasAbertas, qtdTotalQueixas);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SituacaoPrefeitura getSituacaoPrefeitura() {
		return situacaoPrefeitura;
	}

	public void setSituacaoPrefeitura(SituacaoPrefeitura situacaoPrefeitura) {
		this.situacaoPrefeitura = situacaoPrefeitura;
	}

}