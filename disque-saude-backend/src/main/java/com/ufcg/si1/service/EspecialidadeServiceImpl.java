package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.repository.EspecialidadeRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {
	
	@Autowired
	EspecialidadeRepository especialidadeRepository;
	
	public EspecialidadeServiceImpl(EspecialidadeRepository especialidadeRepository) {
		this.especialidadeRepository = especialidadeRepository;
	}

    private List<Especialidade> especialidades;

    public EspecialidadeServiceImpl() {
        especialidades = new ArrayList<>();
    }

    @Override
    public Especialidade procura(int codigo) throws Rep,
            ObjetoInexistenteException {
    	
    	List<Especialidade> especialidades = this.getListaEspecialidade();

        for (Especialidade esp : especialidades) {
        	if(esp.getCodigo() == codigo)
        		return esp;
        }

        throw new ObjetoInexistenteException("Erro Especialidade");
    }

    @Override
    public List<Especialidade> getListaEspecialidade() {
        return this.especialidadeRepository.findAll();
    }

    @Override
    public int size() {
        return this.especialidades.size();
    }
    
    @Override
    public Especialidade getElemento(int posicao) {
    	return this.especialidadeRepository.getOne(posicao);
    	
    }
    
    @Override
    public void insere(Especialidade esp) throws Rep,
            ObjetoJaExistenteException {

    	if (this.existe(esp.getCodigo())) {
    		throw new ObjetoJaExistenteException("Objeto jah existe no array");
    	}
    	
    	this.especialidadeRepository.save(esp);
    }

    @Override
    public boolean existe(int codigo) {
    	List<Especialidade> especialidades = this.getListaEspecialidade();
    	
        for (Especialidade esp : especialidades) {
        	if(esp.getCodigo() == codigo)
        		return true;
        }
        return false;
    }

    // falta corrigir isso
    public Especialidade findById(long id) {
    	List<Especialidade> especialidades = this.getListaEspecialidade();
        for (Especialidade esp: especialidades) {
            if (esp.getCodigo() == id) {
                return esp;
            }
        }
        return null;
    }


}
