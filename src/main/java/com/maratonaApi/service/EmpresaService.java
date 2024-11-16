package com.maratonaApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.maratonaApi.model.Empresa;
import com.maratonaApi.model.repository.EmpresasRepository;

public class EmpresaService {
	@Autowired
	private EmpresasRepository empresaRepository;
	
	// Obter todas as empresas
	public List<Empresa> obterTodo(){
		return empresaRepository.findAll();
	}
	
	// Ler uma empresa pelo ID
	public Empresa read(Integer id) {
		return empresaRepository.findById(id).orElse(null);
	}
	
	//Verificar se um corredor existe pelo email e senha
		public String verificarLoginEmpresa(Empresa empresa, String email, String senha) {
			Empresa empresaEmail = empresaRepository.findByEmail(email);
		    
		    if (empresaEmail != null && empresaEmail.getSenha().equals(senha)) {
		        return "Login bem-sucedido";
		    } else {
		        return "Erro, email ou senha incorretos";
		    }
		}
		
		//Verificar login da empresa e retornar o id_empresa
		public Integer verificarLoginCorredorId(Empresa empresa, String email, String senha) {
		    Empresa empresaEmail = empresaRepository.findByEmail(email);
		    int idEmpresa = -1;
		    
		    if (empresaEmail != null && empresaEmail.getSenha().equals(senha)) {
		        return empresa.getIdEmpresa();
		    }
		    return idEmpresa;
		}
	
	// Inserir
	public Empresa insert(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	// Atualizar
	public Empresa update(Empresa empresa, Integer id) {
		Empresa empresaUpdate = empresaRepository.findById(id).orElse(null);
		if (empresaUpdate != null) {
			empresaUpdate.setNome(empresa.getNome());
			empresaUpdate.setTelefone(empresa.getTelefone());
			empresaUpdate.setEmail(empresa.getEmail());
			empresaUpdate.setUsuario(empresa.getUsuario());
			empresaUpdate.setSenha(empresa.getSenha());
			empresaUpdate.setCnpj(empresa.getCnpj());
			empresaUpdate.setLocal(empresa.getLocal());
			empresaUpdate.setUrlLogo(empresa.getUrlLogo());
			empresaRepository.save(empresaUpdate);
		}
		return empresaUpdate;
	}

	public void delete(Integer id) {
		empresaRepository.deleteById(id);
	}
}
