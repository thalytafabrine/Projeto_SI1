package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@ManyToMany
    private List<Especialidade> especialidades;

    private int numPacientesDiarios;
    
    private int numAtendentes;
    
    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoUnidadeSaude endereco;

    public UnidadeSaude(Long id, List<Especialidade> especialidades, int numAtendentes,
    		int numPacientesDiarios, EnderecoUnidadeSaude endereco) {
    	this.id = id;
    	this.especialidades = especialidades;
    	this.numAtendentes = numAtendentes;
    	this.numPacientesDiarios = numPacientesDiarios;
    	this.endereco = endereco;
    }
    
    public UnidadeSaude() {}

    public List<Especialidade> getEspecialidades() {
        return this.especialidades;
    }

    public void adicionarEspecialidade(Especialidade esp) {
        this.especialidades.add(esp);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumPacientesDiarios() {
		return numPacientesDiarios;
	}

	public void setNumPacientesDiarios(int numPacientesDiarios) {
		this.numPacientesDiarios = numPacientesDiarios;
	}

	public int getNumAtendentes() {
		return numAtendentes;
	}

	public void setNumAtendentes(int numAtendentes) {
		this.numAtendentes = numAtendentes;
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

	public abstract int getNumFuncionarios();

	public abstract float getAtendimentosDiarios();
}
