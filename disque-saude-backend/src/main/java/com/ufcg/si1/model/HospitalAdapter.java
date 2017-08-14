package com.ufcg.si1.model;

import br.edu.ufcg.Hospital;

public class HospitalAdapter extends UnidadeSaude {
	
	private Hospital hospital;
	
	public HospitalAdapter (String descricao, int medicos, float num) {
		this.hospital = new Hospital(descricao, medicos, num);
	}
	
	@Override
	public int getCodigo() {
        return this.hospital.getCodigo();
    }

	@Override
    public void setCodigo(int cod) {
        this.hospital.setCodigo(cod);
    }
	
	@Override
	public String getDescricao() {
        return this.hospital.getDescricao();
    }
	
	@Override
    public void setDescricao(String descricao) {
        this.hospital.setDescricao(descricao);
    }

	@Override
	public int getContador() {
		return this.hospital.getContador();
	}
	
	@Override
	public void setContador(int contador) {
		this.hospital.setContador(contador);
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
