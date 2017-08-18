package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;

import java.util.List;


public interface EspecialidadeService {
	
    Especialidade addEspecialidade(Especialidade esp);
	
    List<Especialidade> getListaEspecialidade();
    
	Especialidade getEspecialidade(Long id) throws Exception;

    int size();

    boolean existe(Long id);
}
