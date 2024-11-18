package com.maratonaApi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maratonaApi.model.Corredor;
import com.maratonaApi.model.repository.CorredoresRepository;
import com.maratonaApi.model.repository.InscricaoRepository;

@Service
public class CorredorService {
	
	@Autowired
	private CorredoresRepository corredorRepository;

	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	// Obter todos os corredores
	public List<Corredor> obterTodos(){
		return corredorRepository.findAll();
	}

	//Lista corredores inscritos de um determinada maratona
	public List<Corredor> obterCorredoresInscritosPorMaratona(Integer idMaratona) {
		return inscricaoRepository.findCorredoresInscritosByMaratona(idMaratona);
	}

	//Lista corredores participando de um determinado maratona
	public List<Corredor> obterCorredoresParticipadoPorMaratona(Integer idMaratona) {
		return inscricaoRepository.findCorredoresParticipandoByMaratona(idMaratona);
	}

	//Lista corredores concluiram certa maratona
	public List<Corredor> obterCorredoresConcluiramPorMaratona(Integer idMaratona) {
		return inscricaoRepository.findCorredoresConcluiramByMaratona(idMaratona);
	}

	// Ler um corredor pelo ID
	public Corredor read(Integer idCorredor) {
		return corredorRepository.findById(idCorredor).orElse(null);
	}

	// Inserir um novo corredor
	public Corredor insert(Corredor corredor) {
		return corredorRepository.save(corredor);
	}

	//verifica o login do corredor e retorna seu id se feito com sucesso
	public Integer verificarLoginCorredorId(String email, String senha) {
		Corredor corredorEmail = corredorRepository.findByEmail(email);

		if (corredorEmail != null && corredorEmail.getSenha().equals(senha)) {
			return corredorEmail.getIdCorredor();  // Retorna o id do Corredor encontrado
		}
		return -1;  // Retorna -1 se o login falhar
	}

	// Atualizar dados do corredor
	public Corredor update(Corredor corredor, Integer idCorredor){
		Corredor corredorUpdate = corredorRepository.findById(idCorredor).orElse(null);
		if (corredorUpdate != null) {
			corredorUpdate.setNome(corredor.getNome());
			corredorUpdate.setTelefone(corredor.getTelefone());
			corredorUpdate.setEmail(corredor.getEmail());
			corredorUpdate.setSenha(corredor.getSenha());
			corredorUpdate.setCpf(corredor.getCpf());
			corredorUpdate.setEndereco(corredor.getEndereco());
			corredorUpdate.setPaisOrigem(corredor.getPaisOrigem());
			corredorUpdate.setDataNascimento(corredor.getDataNascimento());
			corredorUpdate.setGenero(corredor.getGenero());
			corredorRepository.save(corredorUpdate);
		}
		return corredorUpdate;
	}
	
	// Deletar um corredor
	public void delete(Integer idCorredor) {
		corredorRepository.deleteById(idCorredor);
	}
}
