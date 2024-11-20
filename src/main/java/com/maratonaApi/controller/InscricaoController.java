package com.maratonaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maratonaApi.model.Inscricao;
import com.maratonaApi.service.InscricaoService;

@RestController
@RequestMapping("/api/inscricoes")
@CrossOrigin(origins = "http://192.168.0.30:8081") // Permite o CORS para o frontend configurado
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    // Retorna todas as inscrições
    @GetMapping
    public List<Inscricao> listAll() {
        return inscricaoService.obterTodo();
    }

    // Retorna uma inscrição específica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> getById(@PathVariable Integer id) {
        Inscricao inscricao = inscricaoService.read(id);
        if (inscricao == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se a inscrição não for encontrada
        }
        return ResponseEntity.ok(inscricao);  // Retorna a inscrição com status 200
    }

    // Insere uma nova inscrição no banco
    @PostMapping
    public ResponseEntity<Inscricao> insert(@RequestBody Inscricao inscricao) {
        Inscricao novaInscricao = inscricaoService.insert(inscricao);
        return ResponseEntity.status(201).body(novaInscricao);  // Retorna o status 201 (Criado)
    }

    // Atualiza uma inscrição existente pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> update(@RequestBody Inscricao inscricao, @PathVariable Integer id) {
        Inscricao inscricaoAtualizada = inscricaoService.update(inscricao, id);
        if (inscricaoAtualizada == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se a inscrição não for encontrada
        }
        return ResponseEntity.ok(inscricaoAtualizada);  // Retorna a inscrição atualizada com status 200
    }

    // Deleta uma inscrição pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean isDeleted = inscricaoService.deleteById(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();  // Retorna 404 se não encontrar a inscrição
        }
        return ResponseEntity.noContent().build();  // Retorna 204 para exclusão bem-sucedida
    }

    // Endpoint para desistir da participação
    @PutMapping("/{id}/desistir")
    public ResponseEntity<Inscricao> desistir(@PathVariable Integer id) {
        Inscricao inscricao = inscricaoService.desistirParticipacao(id);
        if (inscricao == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se a inscrição não for encontrada
        }
        return ResponseEntity.ok(inscricao);  // Retorna a inscrição com status 200
    }

    // Endpoint para finalizar a participação
    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Inscricao> finalizar(@PathVariable Integer id) {
        Inscricao inscricao = inscricaoService.finalizarParticipacao(id);
        if (inscricao == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 se a inscrição não for encontrada
        }
        return ResponseEntity.ok(inscricao);  // Retorna a inscrição com status 200
    }
}
