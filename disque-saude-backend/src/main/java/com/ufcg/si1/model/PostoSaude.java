package com.ufcg.si1.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "posto")
public class PostoSaude extends UnidadeSaude {

	public PostoSaude(Long id, String descricao, List<Especialidade> especialidades, EnderecoUnidadeSaude endereco,
			int numMedicos, float numPacientes) {
		super(id, descricao, especialidades, endereco, numMedicos, numPacientes);
	}
    
    public PostoSaude() {}

}
