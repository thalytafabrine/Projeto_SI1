package com.ufcg.si1.model;

import br.edu.ufcg.Hospital;

public class HospitalAdapter extends UnidadeSaude {
	
	private Hospital hospital;
	
	public HospitalAdapter (String descricao, int medicos, float num) {
		this.hospital = new Hospital(descricao, medicos, num);
	}
	
	@Override
	public int getNumFuncionarios() {
		return this.hospital.getNumeroMedicos();
	}

	@Override
	public float getAtendimentosDiarios() {
		return this.hospital.getNumeroPacientesDia();
	}
	
}
