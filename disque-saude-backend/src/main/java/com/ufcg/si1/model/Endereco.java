package com.ufcg.si1.model;

public class Endereco {

	private String rua;

	private String uf;

	private String cidade;

	public Endereco(String rua, String uf, String cidade) {
		this.rua = rua;
		this.uf = uf;
		this.cidade = cidade;
	}

	public String getRua() {
		return this.rua;
	}

	public String getUf() {
		return this.uf;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Endereco other = (Endereco) obj;

		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua)) {
			return false;
		}
		
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf)) {
			return false;
		}
		
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade)) {
			return false;
		}
		
		return true;
	}
	
}
