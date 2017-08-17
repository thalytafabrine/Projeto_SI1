package com.ufcg.si1.service;

import java.util.List;

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

		List<Administrador> todosOsAdministradores = administradorRepository.findAll();

		for (Administrador administrador2 : todosOsAdministradores) {
			if (administrador2.getEmail().equals(administrador.getEmail())) {
				return null;
			}
		}
		return administradorRepository.save(administrador);
	}

	public Administrador logar(Administrador administrador) {

		List<Administrador> todosOsAdministradores = administradorRepository.findAll();

		for (Administrador administrador2 : todosOsAdministradores) {
			if (administrador2.getEmail().equals(administrador.getEmail())) {
				if (administrador2.getSenha().equals(administrador.getSenha())) {
					return administrador2;
				}
			}
		}
		return null;
	}
}
