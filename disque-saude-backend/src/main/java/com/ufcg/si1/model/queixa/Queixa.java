package com.ufcg.si1.model.queixa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Pessoa;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
	@JsonSubTypes.Type(value = QueixaAlimentar.class, name = "ALIMENTAR"),
	@JsonSubTypes.Type(value = QueixaAnimal.class, name = "ANIMAL")
	})
public class Queixa {
	
	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	@OneToOne(cascade=CascadeType.ALL)
	private Pessoa solicitante;
	
	@OneToOne(cascade=CascadeType.ALL)
	public StatusQueixa status;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Endereco endereco;

	private String comentario = "";

	public Queixa() {}

	public Queixa(String descricao, String comentario, StatusQueixa status, String nome, String email, String rua, String cidade, String uf) {
		this.descricao = descricao;
		this.comentario = comentario;
		this.status = status;
		this.solicitante = new Pessoa(nome, email);
		this.endereco = new Endereco(rua, uf, cidade);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusQueixa getStatus() {
		return this.status;
	}

	public void setStatus(StatusQueixa status) {
		this.status = status;
	}

	public void abrir() throws Exception {
		if(this.status == null){
			this.status = new QueixaAberta();
		}else{
			this.status = status.abrirQueixa();
		}
	}

	public void fechar() throws Exception {
		this.status = status.fecharQueixa();
	}
	
	public void resolver() throws Exception {
		this.status = status.resolverQueixa();
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pessoa getSolicitante() {
		return this.solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
		
		Queixa other = (Queixa) obj;
		if (id != other.getId())
			return false;
		return true;
	}

}
