package com.ufcg.si1.model;

import com.ufcg.si1.enums.SituacaoGeralQueixas;

public class PrefeituraCaos implements SituacaoPrefeitura {

	private static final double INDICERUIM = 0.05;
	private static final double INDICEREGULAR = 0.02;
	
	@Override
	public SituacaoGeralQueixas getSituacaoGeral(double qtdQueixaAberta, int qtdQueixaTotal) {
		double relacao = qtdQueixaAberta / qtdQueixaTotal;
		if (relacao > INDICERUIM) {
			return SituacaoGeralQueixas.RUIM;
		} else if (relacao > INDICEREGULAR) {
			return SituacaoGeralQueixas.REGULAR;
		}else{
			return SituacaoGeralQueixas.BOM;
		}
	}
}
