package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufcg.si1.enums.SituacaoGeralQueixas;
import com.ufcg.si1.enums.SituacaoPrefeituraEnum;

@Entity
public class Prefeitura {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Transient
	@JsonIgnore
	private SituacaoPrefeitura situacaoPrefeitura;
	
	private SituacaoPrefeituraEnum situacaoPrefeituraEnum;

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
	
	public SituacaoPrefeituraEnum getSituacaoPrefeituraEnum() {
		if(this.situacaoPrefeitura instanceof PrefeituraNormal)
			situacaoPrefeituraEnum = SituacaoPrefeituraEnum.NORMAL;
		else if (this.situacaoPrefeitura instanceof PrefeituraExtra)
			situacaoPrefeituraEnum = SituacaoPrefeituraEnum.EXTRA;
		return situacaoPrefeituraEnum;
	}
	
	public void setSituacaPrefeituraEnum(SituacaoPrefeituraEnum situacao) {
		this.situacaoPrefeituraEnum = situacao;
	}
}