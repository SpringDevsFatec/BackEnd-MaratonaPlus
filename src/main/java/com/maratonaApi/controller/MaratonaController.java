package com.maratonaApi.controller;

import java.util.List;
import java.util.Map;

import com.maratonaApi.dto.MaratonaComEmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maratonaApi.model.Maratona;
import com.maratonaApi.service.MaratonaService;

@RestController
@RequestMapping("/api/maratonas")
@CrossOrigin(origins = "*/")

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
    public ResponseEntity<?> getMaratonaWithEmpresa(@PathVariable Integer id) {
        MaratonaComEmpresaDTO dto = maratonaService.getMaratonaWithEmpresa(id);

        if (dto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }


    // Verifica se a maratona tem vagas para inscrição
    @GetMapping("/{id}/em-andamento")
    public boolean estaEmAndamento(@PathVariable Integer id) {
        return maratonaService.estaEmAndamento(id);
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
    @GetMapping("/criador/{criador}")
    public List<Maratona> listarPorCriador(@PathVariable Integer criador) {
        return maratonaService.listarPorCriador(criador);
    }

    // Insere uma nova maratona
    @PostMapping
    public Maratona insert(@RequestBody Maratona maratona) {

        System.out.println(maratona);
        return maratonaService.insert(maratona);
    }

    // Atualiza uma maratona existente pelo ID
    @PutMapping("/{id}")
    public Maratona update(@RequestBody Maratona maratona, @PathVariable Integer id) {
        return maratonaService.update(maratona, id);
    }

    // Endpoint para abiri a maratona
    @PutMapping("/{id}/abrir")
    public ResponseEntity<Maratona> abrir(@PathVariable Integer id) {
        Maratona maratona = maratonaService.abrir(id);
        if (maratona == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se a maratona não for encontrada
        }
        return ResponseEntity.ok(maratona);  // Retorna a maratona com status 200
    }

    // Endpoint para iniciar a maratona
    @PutMapping("/{id}/iniciar")
    public ResponseEntity<Maratona> iniciar(@PathVariable Integer id) {
        Maratona maratona = maratonaService.iniciar(id);
        if (maratona == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se a maratona não for encontrada
        }
        return ResponseEntity.ok(maratona);  // Retorna a maratona com status 200
    }

    // Endpoint para concluir a maratona
    @PutMapping("/{id}/concluir")
    public ResponseEntity<Maratona> concluir(@PathVariable Integer id) {
        Maratona maratona = maratonaService.concluir(id);
        if (maratona == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se a maratona não for encontrada
        }
        return ResponseEntity.ok(maratona);  // Retorna a maratona com status 200
    }

    // Endpoint para cancelar a maratona
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Maratona> cancelar(@PathVariable Integer id) {
        Maratona maratona = maratonaService.cancelar(id);
        if (maratona == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se a maratona não for encontrada
        }
        return ResponseEntity.ok(maratona);  // Retorna a maratona com status 200
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