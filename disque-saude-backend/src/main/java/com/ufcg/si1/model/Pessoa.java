package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa{
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;

	private String email;
	
	private Endereco endereco;

	public Pessoa(String nome, String email, String rua, String uf, String cidade) {
		this.nome = nome;
		this.email = email;
		this.endereco = new Endereco(rua, uf, cidade);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
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
		
		Pessoa other = (Pessoa) obj;
		
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email)) {
			return false;
		}
		
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco)) {
			return false;
		}
		return true;
	}
}
