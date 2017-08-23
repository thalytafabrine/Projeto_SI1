package com.ufcg.si1.model.queixa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ufcg.si1.enums.SituacaoQueixa;

public class QueixaFechada extends StatusQueixa {
	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public StatusQueixa abrirQueixa() throws Exception {
		return new QueixaAberta();
	}

	@Override
	public StatusQueixa resolverQueixa() {
		return new QueixaEmAndamento();
	}

	@Override
	public StatusQueixa fecharQueixa() throws Exception {
		throw new Exception("Queixa já está fechada.");
	}

	@Override
	public SituacaoQueixa getSituacaoQueixa() {
		return SituacaoQueixa.ABERTA;
	}
}
