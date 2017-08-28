package com.ufcg.si1.service;

import com.ufcg.si1.enums.SituacaoGeralQueixas;
import com.ufcg.si1.model.prefeitura.Prefeitura;

public interface PrefeituraService {

	public SituacaoGeralQueixas getSituacaoGeral() throws Exception;

	public Prefeitura modificaStatus(String situacaoPrefeitura);
	
}
