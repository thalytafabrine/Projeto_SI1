package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	@GeneratedValue
	private Integer id;

	private String rua;

	private String uf;

	private String cidade;

	public Endereco(String rua, String uf, String cidade) {
		this.rua = rua;
		this.uf = uf;
		this.cidade = cidade;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
