package com.maratonaApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maratonaApi.model.Maratona;
import com.maratonaApi.model.repository.InscricaoRepository;
import com.maratonaApi.model.repository.MaratonasRepository;

@Service
public class MaratonaService {

	@Autowired
	private MaratonasRepository maratonaRepository;

	@Autowired
	private InscricaoRepository inscricaoRepository;

	// Obter todas as maratonas
	public List<Maratona> obterTodos() {
		return maratonaRepository.findAll();
	}

	// Obter uma maratona pelo ID
	public Maratona read(Integer id) {
		return maratonaRepository.findById(id).orElse(null);
	}

	// Atualizar o status da maratona
	public Maratona updateStatus(Maratona maratona, Integer id) {
		Maratona maratonaUpdate = maratonaRepository.findById(id).orElse(null);
		if (maratonaUpdate != null) {
			maratonaUpdate.setStatus(maratona.getStatus());
			return maratonaRepository.save(maratonaUpdate); // Salva o novo status
		}
		return maratonaUpdate;
	}

	// Listar maratonas por status
	public List<Maratona> listarPorStatus(Maratona.StatusMaratona status) {
		return maratonaRepository.findByStatus(status);
	}

	// Listar maratonas por criador
	public List<Maratona> listarPorCriador(Integer criador) {
		return maratonaRepository.findByCriador(criador);
	}

	// Inserir uma nova maratona
	public Maratona insert(Maratona maratona) {
		// Verificar se a data de início e final são válidas, além do status
		if (maratona.getDataInicio().isAfter(maratona.getDataFinal())) {
			throw new IllegalArgumentException("A data de início não pode ser após a data final.");
		}
		return maratonaRepository.save(maratona);
	}

	// Atualizar uma maratona existente
	public Maratona update(Maratona maratona, Integer idMaratona) {
		Maratona maratonaUpdate = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratonaUpdate != null) {
			// Atualizar todos os campos necessários
			maratonaUpdate.setCriador(maratona.getCriador());
			maratonaUpdate.setNome(maratona.getNome());
			maratonaUpdate.setLocal(maratona.getLocal());
			maratonaUpdate.setDataInicio(maratona.getDataInicio());
			maratonaUpdate.setDataFinal(maratona.getDataFinal());
			maratonaUpdate.setStatus(maratona.getStatus());
			maratonaUpdate.setDescricao(maratona.getDescricao());
			maratonaUpdate.setLimiteParticipantes(maratona.getLimiteParticipantes());
			maratonaUpdate.setDistancia(maratona.getDistancia());
			maratonaUpdate.setValor(maratona.getValor());
			maratonaUpdate.setRegras(maratona.getRegras());
			maratonaUpdate.setTipoTerreno(maratona.getTipoTerreno());
			maratonaUpdate.setClimaEsperado(maratona.getClimaEsperado());
			return maratonaRepository.save(maratonaUpdate);
		}
		return maratonaUpdate;
	}

	// Deletar uma maratona pelo ID
	public void deleteById(Integer idMaratona) {
		maratonaRepository.deleteById(idMaratona);
	}

	// Listar maratonas abertas para um corredor específico
	public List<Maratona> obterAbertasPorCorredor(Integer idCorredor) {
		return maratonaRepository.findMaratonasAbertasPorCorredor(idCorredor); // Este metodo vai buscar as maratonas abertas para o corredor
	}

	// Listar maratonas concluídas por um corredor específico
	public List<Maratona> obterConcluidasPorCorredor(Integer idCorredor) {
		return maratonaRepository.findMaratonasConcluidasPorCorredor(idCorredor); // Este metodo vai buscar as maratonas concluídas para o corredor
	}

	// Verificar se a maratona está aberta para inscrição
	public boolean podeInscrever(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null) {
			// Verifica se o status é "Aberta para Inscrição" ou "Aberta"
			return maratona.getStatus().equals(Maratona.StatusMaratona.ABERTA_PARA_INSCRICAO) ||
					maratona.getStatus().equals(Maratona.StatusMaratona.ABERTA);
		}
		return false; // Se a maratona não for encontrada ou não estiver aberta para inscrições
	}
}
