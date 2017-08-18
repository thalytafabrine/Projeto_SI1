package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repository.AdministradorRepository;


@Service("administradorService")
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	AdministradorRepository administradorRepository;
	
	public AdministradorServiceImpl(AdministradorRepository administradorRepository) {
		this.administradorRepository = administradorRepository;
	}

	public Administrador cadastrar(Administrador administrador) {
		if (administradorRepository.findByEmail(administrador.getEmail()) != null) {
				return null;
		}
		return administradorRepository.save(administrador);
	}

	public Administrador logar(Administrador administrador) {

		return validation(administrador.getEmail(), administrador.getSenha());
	}
	
	public Administrador validation(String email, String senha) {
		Administrador administrador = administradorRepository.findByEmail(email);
		if (administrador != null) {
			if (administrador.getSenha().equals(senha)) {
				return administrador;
			}return null;
		}
		return administrador;
	}
}
