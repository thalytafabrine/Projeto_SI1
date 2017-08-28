package com.ufcg.si1.model.prefeitura;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ufcg.si1.enums.SituacaoGeralQueixas;

@Entity
@DiscriminatorValue(value = "normal")
public class PrefeituraNormal extends SituacaoPrefeitura {

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
