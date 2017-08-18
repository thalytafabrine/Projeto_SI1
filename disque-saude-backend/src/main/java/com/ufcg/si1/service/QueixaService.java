package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();

    Queixa saveQueixa(Queixa queixa) throws Exception;

	Queixa findById(Long id) throws Exception;

	Queixa updateQueixa(Long id, Queixa user) throws Exception;

	Queixa deleteQueixaById(Long id) throws Exception;

    int size();
    
    Queixa fecharQueixa(Queixa queixaAFechar) throws Exception;

//	boolean isUserExist(Queixa user);
	
}
