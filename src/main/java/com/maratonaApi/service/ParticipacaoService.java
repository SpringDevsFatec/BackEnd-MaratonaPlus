package com.maratonaApi.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maratonaApi.model.Participacao;
import com.maratonaApi.model.repository.ParticipacaoRepository;

@Service
public class ParticipacaoService {

    @Autowired
    private ParticipacaoRepository participacaoRepository;

    // Obter todas as participações
    public List<Participacao> listAll() {
        return participacaoRepository.findAll();
    }

    // Obter participações com base no status
    public List<Participacao> listAllStatus(String statusConclusao) {
        return participacaoRepository.findByStatusConclusao(statusConclusao);
    }

    // Buscar uma participação pelo ID
    public Participacao getById(Integer id) {
        return participacaoRepository.findById(id).orElse(null);
    }

    // Buscar a participação com base no ID de inscrição
    public Participacao getInscricaoById(Integer idInscricao) {
        return participacaoRepository.findById(idInscricao).orElse(null);
    }

    // Retorna o tempo inicial de uma participação pelo ID
    public String getTempoInicialById(Integer id) {
        Participacao participacao = participacaoRepository.findById(id).orElse(null);
        if (participacao != null && participacao.getTempoInicio() != null) {
            // Converte o tempo para String (formato HH:mm:ss)
            Timestamp tempoInicio = participacao.getTempoInicio();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            return sdf.format(tempoInicio);
        }
        return null; // Retorna null caso não tenha encontrado a participação ou o tempo inicial
    }

    // Iniciar participação: Atualiza o status para "participando" e salva o tempo de início
    public Participacao iniciarParticipacao(Integer id) {
        Optional<Participacao> participacaoOptional = participacaoRepository.findById(id);
        if (participacaoOptional.isPresent()) {
            Participacao participacao = participacaoOptional.get();
            // Definindo o status para "participando" e o tempo de início
            participacao.setStatusConclusao(Participacao.StatusParticipacao.PARTICIPANDO);
            Timestamp tempoInicio = new Timestamp(System.currentTimeMillis());  // Usando Timestamp aqui
            participacao.setTempoInicio(tempoInicio);
            return participacaoRepository.save(participacao);
        }
        return null;
    }

    // Finalizar participação: Atualiza o status para "finalizado" e salva o tempo final
    public Participacao finalizarParticipacao(Integer id) {
        Optional<Participacao> participacaoOptional = participacaoRepository.findById(id);
        if (participacaoOptional.isPresent()) {
            Participacao participacao = participacaoOptional.get();
            // Definindo o status para "finalizado" e o tempo final
            participacao.setStatusConclusao(Participacao.StatusParticipacao.FINALIZADO);
            Timestamp tempoFim = new Timestamp(System.currentTimeMillis());  // Usando Timestamp aqui
            participacao.setTempoFim(tempoFim);
            // Calculando tempo registrado
            long tempoDecorrido = tempoFim.getTime() - participacao.getTempoInicio().getTime();
            participacao.setTempoRegistrado(new Timestamp(tempoDecorrido)); // Usando Timestamp para tempo registrado
            return participacaoRepository.save(participacao);
        }
        return null;
    }

    // Registrar desistência: Atualiza o status para "desistência"
    public Participacao desistirParticipacao(Integer id) {
        Optional<Participacao> participacaoOptional = participacaoRepository.findById(id);
        if (participacaoOptional.isPresent()) {
            Participacao participacao = participacaoOptional.get();
            // Atualiza o status para "desistência"
            participacao.setStatusConclusao(Participacao.StatusParticipacao.DESISTENCIA);
            return participacaoRepository.save(participacao);
        }
        return null;
    }

    // Concluir a maratona (admin): Atualiza a maratona para "concluída"
    public boolean concluirMaratona(Integer maratonaId) {
        return true;  // Exemplo de sucesso
    }
    // Cancelar a maratona (admin): Atualiza o status das inscrições relacionadas
    public boolean cancelarMaratona(Integer maratonaId) {
        return true;  // Exemplo de sucesso
    }

    // cadastra nova participacao
    public Participacao insert(Participacao participacao) {
        return participacaoRepository.save(participacao);
    }

    // Atualizar uma participação existente
    public Participacao update(Participacao participacao, Integer id) {
        Participacao participacaoUpdate = participacaoRepository.findById(id).orElse(null);
        if (participacaoUpdate != null) {
            participacaoUpdate.setIdInscricao(participacao.getIdInscricao());
            participacaoUpdate.setStatusConclusao(participacao.getStatusConclusao());
            participacaoUpdate.setTempoRegistrado(participacao.getTempoRegistrado());
            participacaoUpdate.setTempoInicio(participacao.getTempoInicio());
            participacaoUpdate.setTempoFim(participacao.getTempoFim());
            participacaoUpdate.setPassos(participacao.getPassos());
            participacaoRepository.save(participacaoUpdate);
        }
        return participacaoUpdate;
    }

    // Atualizar apenas o status de uma participação
    public Participacao updateStatus(Participacao participacao, Integer id) {
        Participacao participacaoUpdate = participacaoRepository.findById(id).orElse(null);
        if (participacaoUpdate != null) {
            participacaoUpdate.setStatusConclusao(participacao.getStatusConclusao());
            participacaoUpdate.setTempoRegistrado(participacao.getTempoRegistrado());
            participacaoUpdate.setTempoInicio(participacao.getTempoInicio());
            participacaoUpdate.setTempoFim(participacao.getTempoFim());
            participacaoRepository.save(participacaoUpdate);
        }
        return participacaoUpdate;
    }

    // delete participacao
    public void delete(Integer idParticipacao) {
        participacaoRepository.deleteById(idParticipacao);
    }
}