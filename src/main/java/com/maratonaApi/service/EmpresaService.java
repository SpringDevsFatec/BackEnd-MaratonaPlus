package com.maratonaApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maratonaApi.model.Empresa;
import com.maratonaApi.model.repository.EmpresasRepository;

@Service
public class EmpresaService {

	private final EmpresasRepository empresaRepository;

	public EmpresaService(EmpresasRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	// Obter todas as empresas
	public List<Empresa> obterTodo(){
		return empresaRepository.findAll();
	}
	
	// Ler uma empresa pelo ID
	public Empresa read(Integer idEmpresa) {
		return empresaRepository.findById(idEmpresa).orElse(null);
	}

	//Verificar login da empresa e retornar o id_empresa
	public Integer verificarLoginEmpresaId(String email, String senha) {
		Empresa empresaEmail = empresaRepository.findByEmail(email);
		if (empresaEmail != null && empresaEmail.getSenha().equals(senha)) {
			return empresaEmail.getIdEmpresa();  // Retorna o id do Corredor encontrado
		}
		return -1;  // Retorna -1 se o login falhar
	}
	
	// Inserir
	public Empresa insert(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	// Atualizar
	public Empresa update(Empresa empresa, Integer idEmpresa) {
		Empresa empresaUpdate = empresaRepository.findById(idEmpresa).orElse(null);
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

	public void delete(Integer idEmpresa) {
		empresaRepository.deleteById(idEmpresa);
	}
}
