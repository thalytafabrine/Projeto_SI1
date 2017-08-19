package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.enums.SituacaoGeralQueixas;

public class PrefeituraExtra implements SituacaoPrefeitura {

	private static final double INDICERUIM = 0.1;
	private static final double INDICEREGULAR = 0.05;
	
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
