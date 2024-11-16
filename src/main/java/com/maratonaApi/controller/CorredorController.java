package com.maratonaApi.controller;
import java.util.List;

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

import com.maratonaApi.model.Corredor;
import com.maratonaApi.service.CorredorService;

@RestController
@RequestMapping("/api/corredores")
@CrossOrigin(origins = "http://192.168.0.30:8081")

public class CorredorController {
	// instancia a classe Corredor service 
    @Autowired
    CorredorService corredorService;
    
    // chama classe service para listar todos os Corredors
    @GetMapping
    public List<Corredor> listAll() {
        return corredorService.obterTodos();
    }
    
    // pega dado id e manda para classe service buscar
    @GetMapping("/{id}")
    public Corredor getById(@PathVariable Integer id) {
        return corredorService.read(id);
    }
    
    // pega dados do corpo da requisição e passa a classe service para inserir
    @PostMapping
    public Corredor insert(@RequestBody Corredor corredor) {
        return corredorService.insert(corredor);
    }
    
    // pega corpo da requisição e manada para classe service para atualizar
    @PutMapping("/{id}")
    public Corredor update(@RequestBody Corredor corredor, @PathVariable Integer id) {
        return corredorService.update(corredor, id);
    }
    
    // pega parametro da requisição e manda para classe servece afim de deletar um Corredor
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        corredorService.delete(id);
        return "Corredor excluído com sucesso!";
    }
    
    // send 1 for class service to search toys that are in destaque gastando o english 
    @PostMapping("/login/{email}&{senha}")
    public String login(@RequestBody Corredor corredor, @PathVariable String email, String senha) {
        return corredorService.verificarLoginCorredor(corredor, email, senha);
    }
}