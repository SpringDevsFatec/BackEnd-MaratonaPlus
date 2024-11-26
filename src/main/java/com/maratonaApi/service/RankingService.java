package com.maratonaApi.service;

import java.io.IOException;
import java.util.*;

import com.maratonaApi.model.*;
import com.maratonaApi.model.repository.*;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    @Autowired
    private ParticipacaoRepository participacaoRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private CorredoresRepository corredorRepository;

    @Autowired
    private MaratonasRepository maratonaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RankingRepository rankingRepository;

    public List<Ranking> gerarRankingPorMaratona(int idMaratona) throws MessagingException, IOException {
        // Busca todas as participações finalizadas
        List<Participacao> participacoes = participacaoRepository.findByStatusConclusao(Participacao.StatusParticipacao.FINALIZADO);

        List<Ranking> rankingList = new ArrayList<>();

        // Cria os objetos de ranking com base no tempo registrado
        for (Participacao participacao : participacoes) {
            // Busca a inscrição correspondente à participação
            Optional<Inscricao> inscricaoOptional = inscricaoRepository.findById(participacao.getIdInscricao());
            if (inscricaoOptional.isPresent()) {
                Inscricao inscricao = inscricaoOptional.get();

                // Verifica se a inscrição pertence à maratona desejada
                if (inscricao.getIdMaratona() == idMaratona) {
                    Ranking ranking = new Ranking();
                    ranking.setIdCorredor(inscricao.getIdCorredor());
                    ranking.setIdMaratona(idMaratona);

                    // Usa o tempo registrado diretamente
                    String tempoRegistrado = participacao.getTempoRegistrado();

                    // Converte "HH:mm:ss" para segundos para ordenação
                    double tempoTotal = converterTempoParaSegundos(tempoRegistrado);
                    ranking.setTempoTotal(tempoTotal);

                    rankingList.add(ranking);
                }
            }
        }

        // Ordena o ranking pelo tempo total
        rankingList.sort(Comparator.comparingDouble(Ranking::getTempoTotal));

        // Define a posição de cada participante
        int posicao = 1;
        for (Ranking ranking : rankingList) {
            ranking.setPosicao(posicao++);
        }

        // Salva o ranking no banco de dados
        rankingRepository.saveAll(rankingList);

        // Envia o e-mail para cada corredor no ranking
        enviarEmailsParaCorredores(rankingList, idMaratona);

        return rankingList;
    }

    private void enviarEmailsParaCorredores(List<Ranking> rankingList, int idMaratona) throws MessagingException, IOException {
        // Recupera a maratona uma única vez
        Maratona maratona = maratonaRepository.findById(idMaratona)
                .orElseThrow(() -> new EntityNotFoundException("Maratona não encontrada!"));

        for (Ranking ranking : rankingList) {
            // Recupera as informações do corredor
            Corredor corredor = corredorRepository.findById(ranking.getIdCorredor())
                    .orElseThrow(() -> new EntityNotFoundException("Corredor não encontrado!"));

            // Configura os dados do e-mail
            String emailTemplatePath = "templates/corredor-participacao.html";
            Map<String, Object> templateModel = Map.of(
                    "nomeCorredor", corredor.getNome(),
                    "nomeMaratona", maratona.getNome(),
                    "posicao", ranking.getPosicao()
            );

            // Envia o e-mail
            emailService.enviarEmailComTemplate(
                    corredor.getEmail(),
                    "Parabéns por finalizar a maratona " + maratona.getNome(),
                    emailTemplatePath,
                    templateModel
            );
        }
    }

    private double converterTempoParaSegundos(String tempo) {
        // Converte "HH:mm:ss" para segundos
        String[] partes = tempo.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        int segundos = Integer.parseInt(partes[2]);
        return horas * 3600 + minutos * 60 + segundos;
    }

    public List<Ranking> obterRankingPorMaratona(int idMaratona) {
        // Retorna o ranking ordenado pelo tempo total
        return rankingRepository.findByIdMaratonaOrderByTempoTotalAsc(idMaratona);
    }
}