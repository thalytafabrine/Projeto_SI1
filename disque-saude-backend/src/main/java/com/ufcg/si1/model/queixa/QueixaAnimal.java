package com.ufcg.si1.model.queixa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "animal-perdido")
public class QueixaAnimal extends Queixa {
	
	private String tipoAnimal;
	
	public QueixaAnimal() {}
	
	public QueixaAnimal(String descricao, String comentario, StatusQueixa status, 
			String nome, String email, String rua, String cidade, String uf, String tipoAnimal) {
		super(descricao, comentario, status, nome, email, rua, cidade, uf);
		this.tipoAnimal = tipoAnimal;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}
