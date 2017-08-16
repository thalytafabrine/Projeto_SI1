package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {

    private List<Especialidade> especialidades;

    public EspecialidadeServiceImpl() {
        especialidades = new ArrayList<>();
    }

    @Override
    public Especialidade procura(int codigo) throws Rep,
            ObjetoInexistenteException {

        for (Especialidade esp : this.especialidades) {
        	if(esp.getCodigo() == codigo)
        		return esp;
        }

        throw new ObjetoInexistenteException("Erro Especialidade");
    }

    @Override
    public List<Especialidade> getListaEspecialidade() {
        return this.especialidades;
    }

    @Override
    public int size() {
        return this.especialidades.size();
    }
    
    @Override
    public void insere(Especialidade esp) throws Rep,
            ObjetoJaExistenteException {

    	if (this.existe(esp.getCodigo())) {
    		throw new ObjetoJaExistenteException("Objeto jah existe no array");
    	}
    	
    	this.especialidades.add(esp);
    }

    @Override
    public boolean existe(int codigo) {
        for (Especialidade esp : this.especialidades) {
        	if(esp.getCodigo() == codigo)
        		return true;
        }
        return false;
    }

    // falta corrigir isso
    public Especialidade findById(long id) {
        for (Especialidade esp: this.especialidades) {
            if (esp.getCodigo() == id) {
                return esp;
            }
        }
        return null;
    }


}
