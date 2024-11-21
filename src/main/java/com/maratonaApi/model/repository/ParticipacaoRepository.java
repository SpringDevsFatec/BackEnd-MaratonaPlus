package com.maratonaApi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maratonaApi.model.Participacao;

public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {
	
	List<Participacao> findByStatusConclusao(Participacao.StatusParticipacao statusConclusao);

	Participacao findByIdInscricao(int idInscricao);
}