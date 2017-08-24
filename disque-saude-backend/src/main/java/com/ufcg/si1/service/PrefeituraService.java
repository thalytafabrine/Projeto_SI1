package com.ufcg.si1.service;

import com.ufcg.si1.enums.SituacaoGeralQueixas;
import com.ufcg.si1.model.prefeitura.SituacaoPrefeitura;

public interface PrefeituraService {

	public SituacaoGeralQueixas getSituacaoGeral() throws Exception;

	public void setSituacaoPrefeitura(SituacaoPrefeitura situacaoPrefeitura);
	
}
