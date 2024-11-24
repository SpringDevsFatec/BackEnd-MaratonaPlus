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
	
	// Ler uma maratona pelo ID
	public Maratona read(Integer id) { return maratonaRepository.findById(id).orElse(null); }


	
	//lista maratonas com base no status
		
		
	//lista maratonas por criador
	
	
	// Inserir
	public Maratona insert(Maratona maratona) {
		return maratonaRepository.save(maratona);
	}
	
	// Atualizar
	public Maratona update(Maratona maratona, Integer idMaratona) {
		Maratona maratonaUpdate = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratonaUpdate != null) {
			maratonaUpdate.setCriador(maratona.getCriador());
			maratonaUpdate.setNome(maratona.getNome());
			maratonaUpdate.setLocal(maratona.getLocal());
			maratonaUpdate.setDataInicio(maratona.getDataInicio());
			maratonaUpdate.setStatus(maratona.getStatus());
			maratonaUpdate.setDescricao(maratona.getDescricao());
			maratonaUpdate.setDataFinal(maratona.getDataFinal());
			maratonaUpdate.setLimiteParticipantes(maratona.getLimiteParticipantes());
			maratonaUpdate.setRegras(maratona.getRegras());
			maratonaUpdate.setDistancia(maratona.getDistancia());
			maratonaUpdate.setRegras(maratona.getRegras());
			maratonaUpdate.setValor(maratona.getValor());
			maratonaUpdate.setTipoTerreno(maratona.getTipoTerreno());
			maratonaUpdate.setClimaEsperado(maratona.getClimaEsperado());
			return maratonaRepository.save(maratonaUpdate);
			
		};
		return maratonaUpdate; 
	}
	
	//atualizar status da maratona
	public Maratona updateStatus(Maratona maratona, Integer id) {
		Maratona maratonaUpdate = maratonaRepository.findById(id).orElse(null);
		if (maratonaUpdate != null) {
			maratonaUpdate.setStatus(maratona.getStatus());
			return maratonaRepository.save(maratonaUpdate);
		
		};
		return maratonaUpdate; 
	}
	
	// Deletar
	public void deleteById(Integer idMaratona) {
		maratonaRepository.deleteById(idMaratona);
	}
	
	
}
