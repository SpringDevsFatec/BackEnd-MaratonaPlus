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

import com.maratonaApi.model.Participacao;
import com.maratonaApi.service.ParticipacaoService;

@RestController
@RequestMapping("/api/participacoes")
@CrossOrigin(origins = "http://192.168.0.30:8081")

public class ParticipacaoController {
	// instancia a classe Participacao service 
    @Autowired
    ParticipacaoService participacaoService;
    
    // chama classe service para listar todos as Participacaos
    @GetMapping
    public List<Participacao> listAll() {
        return participacaoService.listAll();
    }

    // chama classe service para listar todos as Participacaos por status
    @GetMapping("/status/{statusConclusao}")
    public List<Participacao> listAllStatus(@PathVariable String statusConclusao) {
        return participacaoService.listAllStatus(statusConclusao);
    }

    // pega dado id e manda para classe service buscar
    @GetMapping("/{id}")
    public Participacao getById(@PathVariable Integer id) {
        return participacaoService.getById(id);
    }

    // pega dado id e manda para classe service buscar
    @GetMapping("/participacao-inscricao/{idInscricao}")
    public Participacao getInscricaoById(@PathVariable Integer idInscricao) {
        return participacaoService.getInscricaoById(idInscricao);
    }

    // pega dado id e manda para classe service buscar
    @GetMapping("/tempo-inicial/{id}")
    public Participacao getTempoInicialById(@PathVariable Integer id) {
        return participacaoService.getTempoInicioalById(id);
    }
    
    // pega dados do corpo da requisição e passa a classe service para inserir
    @PostMapping
    public Participacao insert(@RequestBody Participacao participacao) {
        return participacaoService.insert(participacao);
    }
    
    // pega corpo da requisição e manada para classe service para atualizar
    @PutMapping("/{id}")
    public Participacao update(@RequestBody Participacao participacao, @PathVariable Integer id) {
        return participacaoService.update(participacao, id);
    }

    // pega corpo da requisição e manada para classe service para atualizar
    @PutMapping("/status/{id}")
    public Participacao updateStatus(@RequestBody Participacao participacao, @PathVariable Integer id) {
        return participacaoService.updateStatus(participacao, id);
    }
    
    // pega parametro da requisição e manda para classe servece afim de deletar um Participacao
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        participacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}