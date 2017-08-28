package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
	
	@Autowired
	UnidadeSaudeRepository unidadeSaudeRepository;

    public UnidadeSaudeServiceImpl(UnidadeSaudeRepository unidadeSaudeRepository) {
    	this.unidadeSaudeRepository = unidadeSaudeRepository;
    }

    @Override
    public List<UnidadeSaude> getAll() {
        return this.unidadeSaudeRepository.findAll();
    }

    @Override
    public UnidadeSaude insere(UnidadeSaude unidadeSaude){
        return this.unidadeSaudeRepository.save(unidadeSaude);
    }

    @Override
    public boolean existe(Long id) {
    	return this.unidadeSaudeRepository.exists(id);
    }

    @Override
    public UnidadeSaude findById(Long id) throws Exception {
        UnidadeSaude unidade = this.unidadeSaudeRepository.findOne(id);
        if (unidade == null)
        	throw new Exception("Não existe unidade de saúde com id " + id);
        return unidade;
    }

    @Override
    public UnidadeSaude findByBairro(String bairro) {
        return this.unidadeSaudeRepository.findByBairro(bairro);
    }

	@Override
	public List<Especialidade> getEspecialidades(Long id) throws Exception {
		UnidadeSaude unidade = this.findById(id);
		return unidade.getEspecialidades();
	}

	@Override
	public void adicionarEspecialidade(Especialidade especialidade, Long id) throws Exception {
		UnidadeSaude unidade = this.findById(id);
		unidade.getEspecialidades().add(especialidade);
		
	}

	@Override
	public Float getMediaMedicoPaciente(String bairro) {
		UnidadeSaude unidadeSaudeEncontrada = this.findByBairro(bairro);
		float taxa = unidadeSaudeEncontrada.getNumMedicos()/unidadeSaudeEncontrada.getNumPacientes();
		return taxa;
	}
}