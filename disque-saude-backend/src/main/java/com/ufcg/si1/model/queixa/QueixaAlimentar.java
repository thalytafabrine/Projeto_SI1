package com.ufcg.si1.model.queixa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "alimentar")
public class QueixaAlimentar extends Queixa {
 	
 	public QueixaAlimentar () {
 		super();
 	}
 	
 	public QueixaAlimentar (String descricao, String comentario, StatusQueixa status, String nome, String email, String rua, String cidade, String uf) {
 		super(descricao, comentario, status, nome, email, rua, cidade, uf);
 	}

}
