package com.maratonaApi.controller;
import java.util.List;

import com.maratonaApi.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maratonaApi.model.Empresa;
import com.maratonaApi.service.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://192.168.0.30:8081")

public class EmpresaController {
	// instancia a classe Empresa service 
    @Autowired
    EmpresaService empresaService;
    
    // chama classe service para listar todos os Empresas
    @GetMapping
    public List<Empresa> listAll() {
        return empresaService.obterTodo();
    }
    
    // pega dado id e manda para classe service buscar
    @GetMapping("/{id}")
    public Empresa getById(@PathVariable Integer id) {
        return empresaService.read(id);
    }
    
    // pega dados do corpo da requisição e passa a classe service para inserir
    @PostMapping
    public Empresa insert(@RequestBody Empresa empresa) {
        return empresaService.insert(empresa);
    }

    // send 1 for class service to search toys that are in destaque gastando o english
    @PostMapping("/login")
    public Integer login(@RequestBody LoginRequest loginRequest) {
        return empresaService.verificarLoginEmpresaId(loginRequest.getEmail(), loginRequest.getSenha());
    }

    // pega corpo da requisição e manada para classe service para atualizar
    @PutMapping("/{id}")
    public Empresa update(@RequestBody Empresa empresa, @PathVariable Integer id) {
        return empresaService.update(empresa, id);
    }
    
    // pega parametro da requisição e manda para classe servece afim de deletar um Empresa
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        empresaService.delete(id);
        return "Empresa excluído com sucesso!";
    }
}