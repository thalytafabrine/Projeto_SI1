package com.ufcg.si1.model;

import com.ufcg.si1.enums.SituacaoGeralQueixas;

public interface SituacaoPrefeitura {

  // dependendo da situacao da prefeitura, o criterio de avaliacao muda
  // se normal, mais de 20% abertas eh ruim, mais de 10 eh regular
  // se extra, mais de 10% abertas eh ruim, mais de 5% eh regular
	SituacaoGeralQueixas getSituacaoGeral(double numQueixasAbertas, int qtdQueixaTotal);

}
