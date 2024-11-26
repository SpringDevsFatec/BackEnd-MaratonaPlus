package com.maratonaApi.controller;
import java.util.List;

import com.maratonaApi.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maratonaApi.model.Empresa;
import com.maratonaApi.service.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*/")

public class EmpresaController {

    @Autowired
    EmpresaService empresaService;
    
    // Retorna todas as empresas
    @GetMapping
    public List<Empresa> listAll() {
        return empresaService.obterTodo();
    }
    
    // Retorna uma empresa pelo ID
    @GetMapping("/{id}")
    public Empresa getById(@PathVariable Integer id) {
        return empresaService.read(id);
    }
    
    // Insere uma nova empresa
    @PostMapping
    public Empresa insert(@RequestBody Empresa empresa) {
        return empresaService.insert(empresa);
    }

    // Verifica o login da empresa
    @PostMapping("/login")
    public Integer login(@RequestBody LoginRequest loginRequest) {
        return empresaService.verificarLoginEmpresaId(loginRequest.getEmail(), loginRequest.getSenha());
    }

    // Atualiza uma empresa pelo ID
    @PutMapping("/{id}")
    public Empresa update(@RequestBody Empresa empresa, @PathVariable Integer id) {
        return empresaService.update(empresa, id);
    }
    
    // Exclui uma emprea pelo ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        empresaService.delete(id);
        return "Empresa excluído com sucesso!";
    }
}