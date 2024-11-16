package com.maratonaApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maratonaApi.model.Corredor;
import com.maratonaApi.model.repository.CorredoresRepository;

public class CorredorService {
	
	@Autowired
	private CorredoresRepository corredorRepository;
	
	// Obter todos os corredores
	public List<Corredor> obterTodos(){
		return corredorRepository.findAll();
	}
	
	// Ler um corredor pelo ID
	public Corredor read(Integer id) {
		return corredorRepository.findById(id).orElse(null);
	}
	
	//Verificar se um corredor existe pelo email e senha
	public String verificarLoginCorredor(Corredor corredor, String email, String senha) {
	    Corredor corredorEmail = corredorRepository.findByEmail(email);
	    
	    if (corredorEmail != null && corredorEmail.getSenha().equals(senha)) {
	        return "Login bem-sucedido";
	    } else {
	        return "Erro, email ou senha incorretos";
	    }
	}
	
	//Verificar login da empresa e retornar o id_empresa
	public Integer verificarLoginCorredorId(Corredor corredor, String email, String senha) {
	    Corredor corredorEmail = corredorRepository.findByEmail(email);
	    int idCorredor = -1;
	    
	    if (corredorEmail != null && corredorEmail.getSenha().equals(senha)) {
	        return corredor.getIdCorredor();
	    }
	    return idCorredor;
	}
	
	//Lista corredores de um determinada maratona
	
	
	//Lista corredores participando de um determinado maratona
		
		
	//Lista corredores participando de um determinado maratona
		
		
	//Lista corredores concluiram certa maratona
	
	
	// Inserir um novo corredor
	public Corredor insert(Corredor corredor) {
		return corredorRepository.save(corredor);
	}
	
	// Atualizar dados do corredor
	public Corredor update(Corredor corredor, Integer id){
		Corredor corredorUpdate = corredorRepository.findById(id).orElse(null);
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
	public void delete(Integer id) {
		corredorRepository.deleteById(id);
	}
}
