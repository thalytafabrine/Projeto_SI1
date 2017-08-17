package com.ufcg.si1.service;

import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;

@Service
public interface AdministradorService {
	
	public Administrador cadastrar(Administrador administrador);
	
	public Administrador logar(Administrador administrador);
	
}
