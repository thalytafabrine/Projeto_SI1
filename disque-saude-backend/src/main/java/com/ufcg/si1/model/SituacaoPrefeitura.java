package com.ufcg.si1.model;

public class SituacaoPrefeitura {

  // dependendo da situacao da prefeitura, o criterio de avaliacao muda
  // se normal, mais de 20% abertas eh ruim, mais de 10 eh regular
  // se extra, mais de 10% abertas eh ruim, mais de 5% eh regular
	private double indiceRuim;
	private double indiceRegular;
	
	public SituacaoPrefeitura(double indiceRuim, double indiceRegular) {
		this.indiceRuim = indiceRuim;
		this.indiceRegular = indiceRegular;
	}
	
	public Situacao getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		if (numQueixasAbertas / queixaService > indiceRuim)
			return new SituacaoRuim();
		else if (numQueixasAbertas / queixaService > indiceRegular)
			return new SituacaoRegular();
		else
			return new SituacaoBoa();
	}
}
