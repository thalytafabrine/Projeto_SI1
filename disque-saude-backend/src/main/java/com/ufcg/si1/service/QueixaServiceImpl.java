package com.ufcg.si1.service;

import com.ufcg.si1.enums.SituacaoQueixa;
import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.repository.QueixaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {
	
	@Autowired
	QueixaRepository queixaRepository;
	
	public QueixaServiceImpl(QueixaRepository queixaRepository) {
		this.queixaRepository = queixaRepository;
	}

    public List<Queixa> findAllQueixas() {
        return this.queixaRepository.findAll();
    }

    public Queixa saveQueixa(Queixa queixa) throws Exception {
    	if (queixa == null)
    		throw new Exception("Impossivel salvar queixa");
    	queixa.abrir();
    	return this.queixaRepository.save(queixa);
    }

    public Queixa updateQueixa(Long id, Queixa queixa) throws Exception {
    	Queixa queixaAtual = this.findById(id);
    	if (queixaAtual == null)
    		throw new Exception("Impossível atualizar. Queixa de id " + id + " não encontrada.");
        queixaAtual.setDescricao(queixa.getDescricao());
        queixaAtual.setComentario(queixa.getComentario());
        this.queixaRepository.save(queixaAtual);

        return queixa;
    }

    public Queixa deleteQueixaById(Long id) throws Exception {
    	Queixa queixaExcluida = this.findById(id);
      	if (queixaExcluida == null) {
              throw new Exception("Impossível deletar. Queixa de id " + id + " não encontrada.");
        }
        this.queixaRepository.delete(queixaExcluida);
        return queixaExcluida;
    }

    @Override
    public int size() {
        return this.findAllQueixas().size();
    }

    public void deleteAllQueixas() {
    	this.queixaRepository.deleteAll();
    }

    public Queixa findById(Long id) throws Exception{
        Queixa queixa = this.queixaRepository.findOne(id);
        if (queixa == null)
        	throw new Exception("Queixa nao encontrada.");
        return queixa;
    }

	@Override
	public Queixa fecharQueixa(Queixa queixaAFechar) throws Exception {
		Queixa queixa = this.queixaRepository.findOne(queixaAFechar.getId());
		queixa.situacao = SituacaoQueixa.FECHADA;
		this.queixaRepository.save(queixa);
		return queixaAFechar;
	}

}
