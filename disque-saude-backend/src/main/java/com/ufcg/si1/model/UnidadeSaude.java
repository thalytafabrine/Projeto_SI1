package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto"),
        @JsonSubTypes.Type(value = HospitalAdapter.class, name = "hospital")
})
@Entity
public abstract class UnidadeSaude {

	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	@ManyToMany
	private List<Especialidade> especialidades;
	
	@OneToOne(cascade=CascadeType.ALL)
	private EnderecoUnidadeSaude endereco;
	
	private int numMedicos;
	
	private float numPacientes;

	public UnidadeSaude() {
		super();
	}

	public UnidadeSaude(Long id, String descricao, List<Especialidade> especialidades, EnderecoUnidadeSaude endereco,
			int numMedicos, float numPacientes) {
		this.id = id;
		this.descricao = descricao;
		this.especialidades = especialidades;
		this.endereco = endereco;
		this.numMedicos = numMedicos;
		this.numPacientes = numPacientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public EnderecoUnidadeSaude getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoUnidadeSaude endereco) {
		this.endereco = endereco;
	}

	public int getNumMedicos() {
		return numMedicos;
	}

	public void setNumMedicos(int numMedicos) {
		this.numMedicos = numMedicos;
	}

	public float getNumPacientes() {
		return numPacientes;
	}

	public void setNumPacientes(float numPacientes) {
		this.numPacientes = numPacientes;
	}
}
