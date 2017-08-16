package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();

    void saveQueixa(Queixa queixa);

	Queixa findById(Integer id);

	Queixa updateQueixa(Integer id, Queixa user) throws Exception;

	Queixa deleteQueixaById(Integer id) throws Exception;

    int size();
    
    Queixa fecharQueixa(Queixa queixaAFechar) throws Exception;

//	boolean isUserExist(Queixa user);
	
}
