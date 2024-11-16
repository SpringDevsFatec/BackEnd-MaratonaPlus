package com.maratonaApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maratonaApi.model.Inscricao;
import com.maratonaApi.model.repository.InscricaoRepository;

public class InscricaoService {
	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	// Obter todas as inscrições
	public List<Inscricao> obterTodo(){
		return inscricaoRepository.findAll();
	}
	
	// Ler uma inscricao pelo ID
	public Inscricao read(Integer id) {
		return inscricaoRepository.findById(id).orElse(null);
	}
	
	// Inserir
	public Inscricao insert(Inscricao inscricao) {
		return inscricaoRepository.save(inscricao);
	}
	
	// Atualizar
	public Inscricao update(Inscricao inscricao, Integer id) {
		Inscricao inscricaoUpdate = inscricaoRepository.findById(id).orElse(null);
		if (inscricaoUpdate != null) {
			inscricaoUpdate.setIdInscricao(inscricao.getIdInscricao());
			inscricaoUpdate.setIdCorredor(inscricao.getIdCorredor());
			inscricaoUpdate.setIdMaratona(inscricao.getIdMaratona());
			inscricaoUpdate.setFormaPagamento(inscricao.getFormaPagamento());
			inscricaoUpdate.setStatus(inscricao.getStatus());
			inscricaoUpdate.setIdInscricao(inscricao.getIdInscricao());
		}
		return inscricaoUpdate;
	}
	
	//atualizar o status da inscricao
	
	
	// Deletar
	public void deleteById(Integer id) {
		inscricaoRepository.deleteById(id);
	}	
}
