package com.ufcg.si1.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.edu.ufcg.Hospital;

@Entity
@DiscriminatorValue(value = "hospital")
public class HospitalAdapter extends UnidadeSaude {
	
	private Hospital hospital;
	
	public HospitalAdapter (String descricao, int medicos, float num) {
		this.hospital = new Hospital(descricao, medicos, num);
	}
	
	public HospitalAdapter () {}
	
	@Override
	public int getNumFuncionarios() {
		return this.hospital.getNumeroMedicos();
	}

	@Override
	public float getAtendimentosDiarios() {
		return this.hospital.getNumeroPacientesDia();
	}
	
}
