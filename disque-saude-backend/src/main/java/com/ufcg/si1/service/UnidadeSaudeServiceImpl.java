package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
    private List<UnidadeSaude> unidades;

    private int geraCodigo = 0; // para gerar codigos das queixas cadastradas

    public UnidadeSaudeServiceImpl() {
        unidades = new ArrayList<>();
    }

    @Override
    public UnidadeSaude procura(int codigo) throws Rep,
            ObjetoInexistenteException {
        for (UnidadeSaude unidade : this.unidades) {
        	if (unidade.getCodigo() == codigo) {
        		return unidade;
        	}
        }
        throw new ObjetoInexistenteException("Não achou unidade");
    }

    @Override
    public List<UnidadeSaude> getAll() {
        return this.unidades;
    }

    @Override
    public void insere(UnidadeSaude us) throws Rep,
            ObjetoJaExistenteException {
        if (us == null) {
        	throw new Rep("Erro!");
        } else {
        		us.setCodigo(++geraCodigo);
        }
        
        if (this.existe(us.getCodigo())){
        		throw new ObjetoJaExistenteException("Objeto jah existe no array");
        }
        
        this.unidades.add(us);
    }

    @Override
    public boolean existe(int codigo) {
        for (UnidadeSaude unidade : this.unidades) {
            if (unidade.getCodigo() == codigo) {
            	return true;
            }
        }
    	return false;
    }

    public UnidadeSaude findById(long id) {
        for (UnidadeSaude unidade: this.unidades) {
        	if (unidade.getCodigo() == id){
                    return unidade;
            }
        }
        return null;
    }

    @Override
    public UnidadeSaude findByBairro(String bairro) {
        for (UnidadeSaude unidade: this.unidades) {
        	if (unidade.getDescricao().equals(bairro)){
        		return unidade;
            }
        }
        return null;
    }
}
