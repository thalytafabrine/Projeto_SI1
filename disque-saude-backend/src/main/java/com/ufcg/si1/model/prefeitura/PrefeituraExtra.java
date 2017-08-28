package com.ufcg.si1.model.prefeitura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ufcg.si1.enums.SituacaoGeralQueixas;

@Entity
@DiscriminatorValue(value = "extra")
public class PrefeituraExtra extends SituacaoPrefeitura {

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
