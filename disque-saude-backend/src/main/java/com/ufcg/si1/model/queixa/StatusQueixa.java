package com.ufcg.si1.model.queixa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.ufcg.si1.enums.SituacaoQueixa;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = QueixaAberta.class, name = "ABERTA"),
	@JsonSubTypes.Type(value = QueixaEmAndamento.class, name = "EM_ANDAMENTO"),
	@JsonSubTypes.Type(value = QueixaFechada.class, name = "FECHADA") })
public abstract class StatusQueixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	abstract StatusQueixa abrirQueixa() throws Exception;
	
	abstract StatusQueixa resolverQueixa() throws Exception;
	
	abstract StatusQueixa fecharQueixa()  throws Exception;
	
	public abstract SituacaoQueixa getSituacaoQueixa();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
