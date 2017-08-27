package com.ufcg.si1.service;

import com.ufcg.si1.model.queixa.Queixa;
import com.ufcg.si1.model.queixa.StatusQueixa;
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

    public Queixa salvarQueixa(Queixa queixa) throws Exception {
    	if (queixa == null)
    		throw new Exception("Impossivel salvar queixa");
    	queixa.abrir();
    	return this.queixaRepository.save(queixa);
    }

    public Queixa atualizarQueixa(Long id, Queixa queixa) throws Exception {
    	Queixa queixaAtual = this.procurarPorId(id);
    	if (queixaAtual == null)
    		throw new Exception("Impossível atualizar. Queixa de id " + id + " não encontrada.");
        queixaAtual.setDescricao(queixa.getDescricao());
        queixaAtual.setComentario(queixa.getComentario());
        this.queixaRepository.save(queixaAtual);

        return queixa;
    }

    public Queixa excluirQueixaPorId(Long id) throws Exception {
    	Queixa queixaExcluida = this.procurarPorId(id);
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

    public Queixa procurarPorId(Long id) throws Exception{
        Queixa queixa = this.queixaRepository.findOne(id);
        if (queixa == null)
        	throw new Exception("Queixa nao encontrada.");
        return queixa;
    }

    
    // falta corrigir esse metodo
	@Override
	public Queixa modificaStatusDaQueixa(Long id, String status) throws Exception {
		Queixa queixaEncontrada = this.queixaRepository.findOne(id);
		Queixa queixaAtualizada = this.criaQueixaAtualizada(queixaEncontrada);
		
		StatusQueixa statusAntigo = queixaEncontrada.getStatus(); 
		
		if(status.equals("Abrir")){
			queixaEncontrada.abrir();
		}else if(status.equals("Resolver")){
			queixaEncontrada.resolver();
		}else{
			queixaEncontrada.fechar();
		}
		
		queixaAtualizada.status = queixaEncontrada.getStatus();
		queixaEncontrada.status = statusAntigo;
		
		queixaRepository.save(queixaAtualizada);
		queixaRepository.delete(queixaEncontrada);
		
		return queixaAtualizada;
	}

	@Override
	public Queixa adicionarComentario(Long id, String comentario) {
		Queixa queixa = this.queixaRepository.findOne(id);
		queixa.setComentario(comentario);
		return this.queixaRepository.save(queixa);
	}
	
	private Queixa criaQueixaAtualizada(Queixa queixaEncontrada) {
		return new Queixa(
				queixaEncontrada.getDescricao(),
				queixaEncontrada.getComentario(),
				queixaEncontrada.getStatus(),
				queixaEncontrada.getSolicitante().getNome(),
				queixaEncontrada.getSolicitante().getEmail(),
				queixaEncontrada.getEndereco().getRua(),
				queixaEncontrada.getEndereco().getCidade(),
				queixaEncontrada.getEndereco().getUf()
				);
	}

}
