package com.maratonaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maratonaApi.model.Inscricao;
import com.maratonaApi.service.InscricaoService;

@RestController
@RequestMapping("/api/inscricoes")
@CrossOrigin(origins = "http://192.168.0.30:8081")
public class InscricaoController {
	
	// instancia a classe categoria service 
    @Autowired
    InscricaoService inscricaoService;
    
    // chama classe service para listar todos os categorias
    @GetMapping
    public List<Inscricao> listAll() {
        return inscricaoService.obterTodo();
    }
    
    // pega dado id e manda para classe service buscar
    @GetMapping("/{id}")
    public Inscricao getById(@PathVariable Integer id) {
        return inscricaoService.read(id);
    }
    
    // pega dados do corpo da requisição e passa a classe service para inserir
    @PostMapping
    public Inscricao insert(@RequestBody Inscricao categoria) {
        return inscricaoService.insert(categoria);
    }
    
    // pega corpo da requisição e manada para classe service para atualizar
    @PutMapping("/{id}")
    public Inscricao update(@RequestBody Inscricao categoria, @PathVariable Integer id) {
        return inscricaoService.update(categoria, id);
    }
    
    // pega parametro da requisição e manda para classe servece afim de deletar um categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
    	inscricaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}