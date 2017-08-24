package com.ufcg.si1.model;

public class PostoSaude extends UnidadeSaude {
	
    private int atendentes;

    private float taxaDiariaAtendimentos;

    public PostoSaude(int numAtendentes, int taxaDiariaAtendimentos) {
        this.atendentes = numAtendentes;
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }
    
    public void setAtendentes(int atendentes) {
        this.atendentes = atendentes;
    }

    public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }
    
    @Override
    public int getNumFuncionarios() {
    	return this.atendentes;
    }

    @Override
    public float getAtendimentosDiarios() {
    	return this.taxaDiariaAtendimentos;
    }
}
