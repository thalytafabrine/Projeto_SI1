package com.ufcg.si1.model.queixa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ufcg.si1.enums.SituacaoQueixa;

@Entity
@DiscriminatorValue(value = "em-andamento")
public class QueixaEmAndamento extends StatusQueixa {
	
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
