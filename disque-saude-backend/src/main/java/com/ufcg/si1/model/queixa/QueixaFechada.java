package com.ufcg.si1.model.queixa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ufcg.si1.enums.SituacaoQueixa;

@Entity
@DiscriminatorValue(value = "fechada")
public class QueixaFechada extends StatusQueixa {

	@Override
	public StatusQueixa abrirQueixa() throws Exception {
		throw new Exception("Queixa já está fechada.");
	}

	@Override
	public StatusQueixa resolverQueixa() throws Exception {
		throw new Exception("Queixa já está fechada.");
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
