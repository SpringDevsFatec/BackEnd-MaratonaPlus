package com.maratonaApi.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.maratonaApi.model.Ranking;
import com.maratonaApi.service.RankingService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/ranking")
@CrossOrigin(origins = "*/")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    // Gera o ranking de uma maratona
    @PostMapping("/maratona/{idMaratona}")
    public ResponseEntity<List<Ranking>> gerarRanking(@PathVariable int idMaratona) {
        List<Ranking> ranking = rankingService.gerarRankingPorMaratona(idMaratona);
        return ResponseEntity.ok(ranking);
    }

    // Obtém o ranking já gerado de uma maratona
    @GetMapping("/maratona/{idMaratona}")
    public ResponseEntity<List<Ranking>> obterRanking(@PathVariable int idMaratona) {
        List<Ranking> ranking = rankingService.obterRankingPorMaratona(idMaratona);
        return ResponseEntity.ok(ranking);
    }
}