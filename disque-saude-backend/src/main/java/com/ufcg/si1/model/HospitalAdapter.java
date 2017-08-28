package com.ufcg.si1.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import br.edu.ufcg.Hospital;

@Entity
@DiscriminatorValue(value = "hospital")
public class HospitalAdapter extends UnidadeSaude {
	
	@Transient
	private Hospital hospital;
	
	public HospitalAdapter(Long id, String descricao, List<Especialidade> especialidades,
			EnderecoUnidadeSaude endereco, int numMedicos, float numPacientes) {
		super(id, descricao, especialidades, endereco, numMedicos, numPacientes);
	}
	
	public HospitalAdapter () {}
	
}
