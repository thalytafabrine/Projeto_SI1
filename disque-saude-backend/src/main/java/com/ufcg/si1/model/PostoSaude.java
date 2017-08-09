package com.ufcg.si1.model;


public class PostoSaude extends UnidadeSaude {
	
    private int atendentes;

    private float taxaDiariaAtendimentos;

    public PostoSaude(String descricao, int at, int taxa) {
        super(descricao);
        this.atendentes = at;
        this.taxaDiariaAtendimentos = taxa;
    }

    public PostoSaude(){
        super();
    }

    // implementacoes vazias
    public int getAtendentes() {
        return atendentes;
    }

    public float taxaDiaria() {
        return taxaDiariaAtendimentos;
    }

    public void setAtendentes(int atendentes) {
        this.atendentes = atendentes;
    }

    public float getTaxaDiariaAtendimentos() {
        return taxaDiariaAtendimentos;
    }

    public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
        this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + atendentes;
		result = prime * result + Float.floatToIntBits(taxaDiariaAtendimentos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PostoSaude other = (PostoSaude) obj;
		
		if (atendentes != other.atendentes)
			return false;
		if (Float.floatToIntBits(taxaDiariaAtendimentos) != Float.floatToIntBits(other.taxaDiariaAtendimentos))
			return false;
		return true;
	}
    
    
}
