package com.ufcg.si1.model;

import com.ufcg.si1.util.ObjWrapper;

public class PrefeituraNormal implements SituacaoPrefeitura {

	@Override
	public ObjWrapper<Integer> getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		if (numQueixasAbertas / queixaService > 0.2) {
			return new ObjWrapper<Integer>(0);
		} else {
			if (numQueixasAbertas / queixaService > 0.1) {
				return new ObjWrapper<Integer>(1);
			}

			return new ObjWrapper<Integer>(2);
		}

	}

}
