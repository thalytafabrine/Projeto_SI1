package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.queixa.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();

    Queixa salvarQueixa(Queixa queixa) throws Exception;

	Queixa procurarPorId(Long id) throws Exception;

	Queixa atualizarQueixa(Long id, Queixa user) throws Exception;

	Queixa excluirQueixaPorId(Long id) throws Exception;

    int size();

	Queixa modificaStatusDaQueixa(Long id, String status) throws Exception;

	Queixa adicionarComentario(Long id, String comentario);

//	boolean isUserExist(Queixa user);
	
}
