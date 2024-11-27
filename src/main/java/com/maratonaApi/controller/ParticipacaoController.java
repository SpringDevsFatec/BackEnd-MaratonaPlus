package com.maratonaApi.controller;

import java.util.List;

import com.maratonaApi.model.Maratona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maratonaApi.model.Participacao;
import com.maratonaApi.service.ParticipacaoService;

@RestController
@RequestMapping("/api/participacoes")
@CrossOrigin(origins = "*/")

public class ParticipacaoController {

    @Autowired
    ParticipacaoService participacaoService;
    
    // Retorna todas as participações
    @GetMapping
    public List<Participacao> listAll() {
        return participacaoService.listAll();
    }

    // Retorna participações com base no status de conclusão
    @GetMapping("/status/{statusConclusao}")
    public List<Participacao> listAllStatus(@PathVariable String statusConclusao) {
        // Validando o status passado
        try {
            Participacao.StatusParticipacao statusEnum = Participacao.StatusParticipacao.valueOf(statusConclusao);
            return participacaoService.listAllStatus(statusEnum);
        } catch (IllegalArgumentException e) {
            // Caso o status fornecido não seja valido
            return List.of(); // Retorna uma lista vazia ou erro
        }
    }

    // Retorna uma participação específica pelo ID
    @GetMapping("/{id}")
    public Participacao getById(@PathVariable Integer id) {
        return participacaoService.getById(id);
    }

    // Retorna uma participação pelo ID de inscrição
    @GetMapping("/por-inscricao/{idInscricao}")
    public Participacao getInscricaoById(@PathVariable Integer idInscricao) {
        return participacaoService.getInscricaoById(idInscricao);
    }

    // Retorna o tempo inicial de uma participação pelo ID
    @GetMapping("/tempo-inicial/{id}")
    public ResponseEntity<String> getTempoInicialById(@PathVariable Integer id) {
        String tempoInicio = participacaoService.getTempoInicialById(id);
        if (tempoInicio != null) {
            return ResponseEntity.ok(tempoInicio); // Retorna o tempo inicial encontrado
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 caso não tenha encontrado a participação ou tempo inicial
        }
    }
    
    // Insere uma nova participação
    @PostMapping
    public Participacao insert(@RequestBody Participacao participacao) {
        return participacaoService.insert(participacao);
    }
    
    // Atualiza uma participação existente pelo ID
    @PutMapping("/{id}")
    public Participacao update(@RequestBody Participacao participacao, @PathVariable Integer id) {
        return participacaoService.update(participacao, id);
    }

    // Atualiza apenas o status de uma participação
    @PutMapping("/status/{id}/distancia/{distancia}")
    public Participacao updateStatus(@RequestBody Participacao participacao, @PathVariable Integer id, @PathVariable Integer distancia) {
        return participacaoService.updateStatus(participacao, id, distancia);
    }

    // Iniciar participação: Atualiza o status de inscrição para "participando" e registra o tempo de início
    @PutMapping("/iniciar/{id}")
    public ResponseEntity<Participacao> iniciarParticipacao(@PathVariable Integer id) {
        Participacao participacao = participacaoService.iniciarParticipacao(id);
        if (participacao != null) {
            return ResponseEntity.ok(participacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Finalizar participação: Atualiza o status de inscrição para "finalizado" e salva o tempo final
    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Participacao> finalizarParticipacao(@PathVariable Integer id) {
        Participacao participacao = participacaoService.finalizarParticipacao(id);
        if (participacao != null) {
            return ResponseEntity.ok(participacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Registrar desistência: Atualiza o status da participação para "desistência"
    @PutMapping("/desistir/{id}")
    public ResponseEntity<Participacao> desistirParticipacao(@PathVariable Integer id) {
        Participacao participacao = participacaoService.desistirParticipacao(id);
        if (participacao != null) {
            return ResponseEntity.ok(participacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*/ Admin pode finalizar a maratona, atualizando o status da maratona
    @PutMapping("/maratona/concluir/{id}")
    public ResponseEntity<Void> concluirMaratona(@PathVariable Integer id) {
        boolean success = participacaoService.concluirMaratona(id);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Admin pode cancelar a maratona, afetando todas as participações
    @PutMapping("/maratona/cancelar/{id}")
    public ResponseEntity<Void> cancelarMaratona(@PathVariable Integer id) {
        boolean success = participacaoService.cancelarMaratona(id);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     */
    
    // Deleta uma participação pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        participacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}