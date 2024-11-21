package com.maratonaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maratonaApi.model.Maratona;
import com.maratonaApi.service.MaratonaService;

@RestController
@RequestMapping("/api/maratonas")
@CrossOrigin(origins = "http://192.168.0.30:8081")

public class MaratonaController {
    @Autowired
    private MaratonaService maratonaService;

    // Retorna todas as maratonas
    @GetMapping
    public List<Maratona> listAll() {
        return maratonaService.obterTodos();
    }

    // Retorna uma maratona específica pelo ID
    @GetMapping("/{id}")
    public Maratona getById(@PathVariable Integer id) {
        return maratonaService.read(id);
    }

    // Verifica se a maratona tem vagas para inscrição
    @GetMapping("/{id}/pode-inscrever")
    public boolean podeInscrever(@PathVariable Integer id) {
        return maratonaService.podeInscrever(id);
    }

    // Retorna maratonas abertas para um corredor específico
    @GetMapping("/abertas-por-corredor/{idCorredor}")
    public List<Maratona> listAbertasByCorredor(@PathVariable Integer idCorredor) {
        return maratonaService.obterAbertasPorCorredor(idCorredor);
    }

    // Retorna maratonas concluídas por um corredor específico
    @GetMapping("/concluidas-por-corredor/{idCorredor}")
    public List<Maratona> listConcluidasByCorredor(@PathVariable Integer idCorredor) {
        return maratonaService.obterConcluidasPorCorredor(idCorredor);
    }

    // Retorna maratonas com base no status
    @GetMapping("/status/{status}")
    public List<Maratona> listarPorStatus(@PathVariable String status) {
        // Validando o status passado
        try {
            Maratona.StatusMaratona statusEnum = Maratona.StatusMaratona.valueOf(status);
            return maratonaService.listarPorStatus(statusEnum);
        } catch (IllegalArgumentException e) {
            // Caso o status fornecido não seja valido
            return List.of(); // Retorna uma lista vazia ou erro
        }
    }

    // Retorna maratonas criadas por um usuário específico
    @GetMapping("/criador/{criadorId}")
    public List<Maratona> listarPorCriador(@PathVariable Integer criadorId) {
        return maratonaService.listarPorCriador(criadorId);
    }

    // Insere uma nova maratona
    @PostMapping
    public Maratona insert(@RequestBody Maratona maratona) {
        return maratonaService.insert(maratona);
    }

    // Atualiza uma maratona existente pelo ID
    @PutMapping("/{id}")
    public Maratona update(@RequestBody Maratona maratona, @PathVariable Integer id) {
        return maratonaService.update(maratona, id);
    }

    // Atualiza uma maratona existente pelo ID
    @PutMapping("/status/{id}")
    public Maratona updateStatus(@RequestBody Maratona maratona, @PathVariable Integer id) {
        return maratonaService.updateStatus(maratona, id);
    }

    // Deleta uma maratona pelo ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        maratonaService.deleteById(id);
        return "Maratona excluída com sucesso!";
    }

}