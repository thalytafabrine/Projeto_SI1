package com.ufcg.si1.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "posto")
public class PostoSaude extends UnidadeSaude {

    public PostoSaude(Long id, String descricao, List<Especialidade> especialidades,
			int numMedicos, int numPacientes, EnderecoUnidadeSaude endereco) {
		super(id, descricao, especialidades, numMedicos, numPacientes, endereco);
	}
    
    public PostoSaude() {}

	@Override
	public int getNumFuncionarios() {
		return this.getNumAtendentes();
	}

	@Override
	public float getAtendimentosDiarios() {
		return this.getNumPacientesDiarios();
	}

}
