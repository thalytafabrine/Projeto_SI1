package com.ufcg.si1.model;

import com.ufcg.si1.enums.SituacaoGeralQueixas;

public class PrefeituraNormal implements SituacaoPrefeitura {

	private static final double INDICERUIM = 0.2;
	private static final double INDICEREGULAR = 0.1;
	
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
