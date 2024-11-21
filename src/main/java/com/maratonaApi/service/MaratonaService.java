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
	public List<Maratona> obterTodos(){
		return maratonaRepository.findAll();
	}

	//Obter maratonas concluidas de um determinado corredor
	public List<Maratona> obterConcluidasPorCorredor(Integer idCorredor) {
		return inscricaoRepository.findMaratonasConcluidasByIdCorredor(idCorredor);
	}

	//Lista maratonas abertas de um determinado corredor
	public List<Maratona> obterAbertasPorCorredor(Integer idCorredor) {
		return inscricaoRepository.findMaratonasAbertasByIdCorredor(idCorredor);
	}

	// Listar maratonas por status
	public List<Maratona> listarPorStatus(Maratona.StatusMaratona status) {
		return maratonaRepository.findByStatus(status);
	}

	// Listar maratonas por criador
	public List<Maratona> listarPorCriador(Integer criador) {
		return maratonaRepository.findByCriador(criador);
	}
	
	// Ler uma maratona pelo ID
	public Maratona read(Integer id) { return maratonaRepository.findById(id).orElse(null); }

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


	// Inserir uma nova maratona
	public Maratona insert(Maratona maratona) {
		// Definindo o status para "ABERTA"
		maratona.setStatus(Maratona.StatusMaratona.ABERTA);
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
			//maratonaUpdate.setCriador(maratona.getCriador());
			maratonaUpdate.setNome(maratona.getNome());
			maratonaUpdate.setLocal(maratona.getLocal());
			maratonaUpdate.setDataInicio(maratona.getDataInicio());
			//maratonaUpdate.setStatus(maratona.getStatus());
			maratonaUpdate.setDescricao(maratona.getDescricao());
			maratonaUpdate.setDataFinal(maratona.getDataFinal());
			maratonaUpdate.setLimiteParticipantes(maratona.getLimiteParticipantes());
			maratonaUpdate.setRegras(maratona.getRegras());
			maratonaUpdate.setDistancia(maratona.getDistancia());
			maratonaUpdate.setRegras(maratona.getRegras());
			maratonaUpdate.setValor(maratona.getValor());
			maratonaUpdate.setTipoTerreno(maratona.getTipoTerreno());
			maratonaUpdate.setClimaEsperado(maratona.getClimaEsperado());

			if (maratona.getDataInicio().isAfter(maratona.getDataFinal())) {
				throw new IllegalArgumentException("A data de início não pode ser após a data final.");
			}
			return maratonaRepository.save(maratonaUpdate);
			
		}
		return maratonaUpdate; 
	}

	// Atualizar status para "EM_ANDAMENTO" de uma maratona
	public Maratona iniciar(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null && maratona.getStatus() != Maratona.StatusMaratona.ABERTA) {
			maratona.setStatus(Maratona.StatusMaratona.EM_ANDAMENTO);
			return maratonaRepository.save(maratona);
		}
		return null;  // Retorna null se a maratona já está em andamento ou não existe
	}

	// Atualizar status para "CONCLUIDA" de uma maratona
	public Maratona concluir(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null && maratona.getStatus() != Maratona.StatusMaratona.EM_ANDAMENTO) {
			maratona.setStatus(Maratona.StatusMaratona.CONCLUIDA);
			return maratonaRepository.save(maratona);
		}
		return null;  // Retorna null se a maratona já está concluida ou não existe
	}

	// Atualizar status para "CANCELADA" de uma maratona
	public Maratona cancelar(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null && maratona.getStatus() != Maratona.StatusMaratona.EM_ANDAMENTO) {
			maratona.setStatus(Maratona.StatusMaratona.CANCELADA);
			return maratonaRepository.save(maratona);
		}
		return null;  // Retorna null se a maratona já está em andamento ou não existe
	}
	
	//atualizar status da maratona
	public Maratona updateStatus(Maratona maratona, Integer id) {
		Maratona maratonaUpdate = maratonaRepository.findById(id).orElse(null);
		if (maratonaUpdate != null) {
			maratonaUpdate.setStatus(maratona.getStatus());
			return maratonaRepository.save(maratonaUpdate);
		
		}
		return maratonaUpdate; 
	}
	
	// Deletar
	public void deleteById(Integer idMaratona) {
		maratonaRepository.deleteById(idMaratona);
	}
	
	
}
