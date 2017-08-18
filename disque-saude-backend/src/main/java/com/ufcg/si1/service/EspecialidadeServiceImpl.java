package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.repository.EspecialidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {
	
	@Autowired
	EspecialidadeRepository especialidadeRepository;
	
	public EspecialidadeServiceImpl(EspecialidadeRepository especialidadeRepository) {
		this.especialidadeRepository = especialidadeRepository;
	}
    
    @Override
    public List<Especialidade> getListaEspecialidade() {
        return this.especialidadeRepository.findAll();
    }
    
    // falta melhorar tratamento das exceptions
    @Override
    public Especialidade getEspecialidade(Long id) throws Exception {
    	Especialidade especialidade = this.especialidadeRepository.findOne(id);
    	if (especialidade == null)
    		throw new Exception("Especialidade com id "+id+" nao existe.");
    	return especialidade;	
    }

    @Override
    public int size() {
        return this.getListaEspecialidade().size();
    }
    
    @Override
    public Especialidade addEspecialidade(Especialidade esp){
    	return this.especialidadeRepository.save(esp);
    }

    @Override
    public boolean existe(Long id) {
    	return this.especialidadeRepository.exists(id);
    }

}
