package com.maratonaApi.service;

import java.util.List;
import java.time.LocalDateTime;  // Para data e hora
import java.time.LocalDate;     // Para data sem hora

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maratonaApi.model.Inscricao;
import com.maratonaApi.model.repository.InscricaoRepository;

@Service
public class InscricaoService {

	@Autowired
	private InscricaoRepository inscricaoRepository;

	// Obter todas as inscrições
	public List<Inscricao> obterTodo() {
		return inscricaoRepository.findAll();
	}

	// Ler uma inscrição pelo ID
	public Inscricao read(Integer idInscricao) {
		return inscricaoRepository.findById(idInscricao).orElse(null);
	}

	// Inserir uma nova inscrição
	public Inscricao insert(Inscricao inscricao) {
		// Definindo o status para "INSCRITO"
		inscricao.setStatus(Inscricao.StatusInscricao.INSCRITO);
		inscricao.setDataHora(LocalDateTime.now());  // Definindo a data/hora de inscrição
		inscricao.setDataParticipacao(LocalDate.now());  // Definindo a data de participação (caso necessário)
		return inscricaoRepository.save(inscricao);
	}

	// Atualizar uma inscrição existente
	public Inscricao update(Inscricao inscricao, Integer idInscricao) {
		Inscricao inscricaoUpdate = inscricaoRepository.findById(idInscricao).orElse(null);  // Busca inscrição existente
		if (inscricaoUpdate != null) {
			// Impede a alteração do status se já foi finalizado ou desistido
			if (inscricaoUpdate.getStatus() == Inscricao.StatusInscricao.FINALIZADO || inscricaoUpdate.getStatus() == Inscricao.StatusInscricao.DESISTENCIA) {
				return null;  // Retorna null se o status não puder ser alterado
			}

			// Atualiza outros campos
			inscricaoUpdate.setIdCorredor(inscricao.getIdCorredor());
			inscricaoUpdate.setIdMaratona(inscricao.getIdMaratona());
			inscricaoUpdate.setFormaPagamento(inscricao.getFormaPagamento());
			inscricaoUpdate.setStatus(inscricao.getStatus());

			// Salva as alterações
			return inscricaoRepository.save(inscricaoUpdate);
		}
		return null;  // Retorna null caso a inscrição não seja encontrada
	}

	// Atualizar status para "DESISTENCIA" de uma inscrição
	public Inscricao desistirParticipacao(Integer idInscricao) {
		Inscricao inscricao = inscricaoRepository.findById(idInscricao).orElse(null);
		if (inscricao != null && inscricao.getStatus() != Inscricao.StatusInscricao.FINALIZADO) {
			inscricao.setStatus(Inscricao.StatusInscricao.DESISTENCIA);
			return inscricaoRepository.save(inscricao);
		}
		return null;  // Retorna null se a inscrição já foi finalizada ou não existe
	}

	// Atualizar status para "FINALIZADO" de uma inscrição
	public Inscricao finalizarParticipacao(Integer idInscricao) {
		Inscricao inscricao = inscricaoRepository.findById(idInscricao).orElse(null);
		if (inscricao != null && inscricao.getStatus() == Inscricao.StatusInscricao.PARTICIPANDO) {
			inscricao.setStatus(Inscricao.StatusInscricao.FINALIZADO);
			return inscricaoRepository.save(inscricao);
		}
		return null;  // Retorna null se a inscrição não estiver em status PARTICIPANDO
	}

	// Deletar uma inscrição pelo ID
	public boolean deleteById(Integer idInscricao) {
		if (inscricaoRepository.existsById(idInscricao)) {
			inscricaoRepository.deleteById(idInscricao);
			return true;  // Retorna true se a inscrição foi deletada com sucesso
		}
		return false;  // Retorna false se a inscrição não existir
	}
}
