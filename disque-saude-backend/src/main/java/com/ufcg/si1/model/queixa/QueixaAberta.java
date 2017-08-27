package com.ufcg.si1.model.queixa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ufcg.si1.enums.SituacaoQueixa;

@Entity
@DiscriminatorValue(value = "aberta")
public class QueixaAberta extends StatusQueixa {
	
	@Override
	public StatusQueixa abrirQueixa() throws Exception {
		throw new Exception("Queixa já esta aberta");
	}

	@Override
	public StatusQueixa resolverQueixa() {
		return new QueixaEmAndamento();
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
