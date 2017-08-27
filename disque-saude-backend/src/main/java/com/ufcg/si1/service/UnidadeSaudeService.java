package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;


public interface UnidadeSaudeService {

    List<UnidadeSaude> getAll();
    
    List<Especialidade> getEspecialidades(Long id) throws Exception;

    UnidadeSaude insere(UnidadeSaude us);

    boolean existe(Long id);

    UnidadeSaude findById(Long id) throws Exception;
    
    void adicionarEspecialidade(Especialidade especialidade, Long id) throws Exception;

    UnidadeSaude findByBairro(String bairro);

	Float getMediaMedicoPaciente(String bairro);
}
