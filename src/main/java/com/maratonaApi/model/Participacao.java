package com.maratonaApi.model;

import java.sql.Timestamp;  // Alteração aqui para Timestamp
import jakarta.persistence.*;

@Entity
@Table(name = "participacao")
public class Participacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participacao")
    private int idParticipacao;

    @Column(name = "id_inscricao")
    private int idInscricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_conclusao")
    private StatusConclusao statusConclusao;

    @Column(name = "tempo_registrado")
    private Timestamp tempoRegistrado;  // Alteração aqui para Timestamp

    @Column(name = "tempo_inicio")
    private Timestamp tempoInicio;  // Alteração aqui para Timestamp

    @Column(name = "tempo_fim")
    private Timestamp tempoFim;  // Alteração aqui para Timestamp

    @Column(name = "passos")
    private int passos;

    // Getters e Setters
    public int getIdParticipacao() {
        return idParticipacao;
    }

    public void setIdParticipacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public int getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(int idInscricao) {
        this.idInscricao = idInscricao;
    }

    public StatusConclusao getStatusConclusao() {
        return statusConclusao;
    }

    public void setStatusConclusao(StatusConclusao statusConclusao) {
        this.statusConclusao = statusConclusao;
    }

    public Timestamp getTempoRegistrado() {
        return tempoRegistrado;
    }

    public void setTempoRegistrado(Timestamp tempoRegistrado) {
        this.tempoRegistrado = tempoRegistrado;
    }

    public Timestamp getTempoInicio() {
        return tempoInicio;
    }

    public void setTempoInicio(Timestamp tempoInicio) {
        this.tempoInicio = tempoInicio;
    }

    public Timestamp getTempoFim() {
        return tempoFim;
    }

    public void setTempoFim(Timestamp tempoFim) {
        this.tempoFim = tempoFim;
    }

    public int getPassos() {
        return passos;
    }

    public void setPassos(int passos) {
        this.passos = passos;
    }

    public enum StatusConclusao {
        FINALIZADO,
        DESISTENCIA,
        PARTICIPANDO
    }
}
