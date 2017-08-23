package com.ufcg.si1.model.queixa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ufcg.si1.enums.SituacaoQueixa;

public class QueixaEmAndamento extends StatusQueixa {
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
		return new QueixaEmAndamento();
	}

	@Override
	public StatusQueixa resolverQueixa() throws Exception {
		throw new Exception("Queixa já está em andamento.");
	}

	@Override
	public StatusQueixa fecharQueixa() {
		return new QueixaFechada();
	}

	@Override
	public SituacaoQueixa getSituacaoQueixa() {
		return SituacaoQueixa.ABERTA;
	}
}
