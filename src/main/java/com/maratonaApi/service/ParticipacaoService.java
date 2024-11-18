package com.maratonaApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maratonaApi.model.Participacao;
import com.maratonaApi.model.repository.ParticipacaoRepository;

@Service
public class ParticipacaoService {

    // instancia classe participacao repository
    @Autowired
    private ParticipacaoRepository participacaoRepository;

    // busca tudo
    public List<Participacao> listAll() {
        return participacaoRepository.findAll();
    }

    // busca tudo por status
    public List<Participacao> listAllStatus(String statusConclusao) {
        return participacaoRepository.findByStatusConclusao(statusConclusao);
    }

    // busca por id
    public Participacao getById(Integer id) {
        return participacaoRepository.findById(id).orElse(null);
    }

    // busca o id_participacao baseado no id_inscricao
    public Participacao getInscricaoById(Integer idInscricao) {
        return participacaoRepository.findById(idInscricao).orElse(null);
    }

    // busca tempo inicial da participacao por id
    public Participacao getTempoInicioalById(Integer id) {
        return participacaoRepository.findById(id).orElse(null);
    }

    // cadastra nova participacao
    public Participacao insert(Participacao participacao) {
        return participacaoRepository.save(participacao);
    }

    // atualiza participacao
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

    // atualiza status participacao
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