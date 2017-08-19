package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();

    Queixa abrirQueixa(Queixa queixa) throws Exception;

	Queixa procurarPorId(Long id) throws Exception;

	Queixa atualizarQueixa(Long id, Queixa user) throws Exception;

	Queixa excluirQueixaPorId(Long id) throws Exception;

    int size();
    
    Queixa fecharQueixa(Queixa queixaAFechar) throws Exception;

//	boolean isUserExist(Queixa user);
	
}
