package com.ufcg.si1.model;

public class PostoSaude extends UnidadeSaude {
	
    private int atendentes;

    private float taxaDiariaAtendimentos;

    public PostoSaude(String descricao, int numAtendentes, int taxaDiariaAtendimentos) {
        super(descricao);
        this.atendentes = numAtendentes;
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }

    public PostoSaude() {
        super();
    }

    public int getAtendentes() {
        return this.atendentes;
    }

    public void setAtendentes(int atendentes) {
        this.atendentes = atendentes;
    }

    public float getTaxaDiariaAtendimentos() {
        return this.taxaDiariaAtendimentos;
    }

    public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }
    
    @Override
    public int getNumFuncionarios() {
    	return this.getAtendentes();
    }

    @Override
    public float getAtendimentosDiarios() {
    	return this.getTaxaDiariaAtendimentos();
    }
}
