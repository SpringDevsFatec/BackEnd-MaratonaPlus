package com.maratonaApi.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

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
    private StatusParticipacao statusConclusao;
	@Column(name = "tempo_registrado")
    private Timestamp tempoRegistrado;
	@Column(name = "tempo_inicio")
    private Timestamp tempoInicio;
	@Column(name = "tempo_fim")
    private Timestamp tempoFim;
	@Column(name = "passos")
    private int Passos;

    public Participacao() {
    }

    public Participacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public Participacao(int idParticipacao, int idInscricao, StatusParticipacao statusConclusao, Timestamp tempoRegistrado, Timestamp tempoFim, Timestamp tempoInicio, int passos) {
        this.idParticipacao = idParticipacao;
        this.idInscricao = idInscricao;
        this.statusConclusao = statusConclusao;
        this.tempoRegistrado = tempoRegistrado;
        this.tempoFim = tempoFim;
        this.tempoInicio = tempoInicio;
        Passos = passos;
    }

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

    public Timestamp getTempoRegistrado() {
        return tempoRegistrado;
    }

    public void setTempoRegistrado(Timestamp tempoRegistrado) {
        this.tempoRegistrado = tempoRegistrado;
    }

    public StatusParticipacao getStatusConclusao() {
        return statusConclusao;
    }

    public void setStatusConclusao(StatusParticipacao statusConclusao) {
        this.statusConclusao = statusConclusao;
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
        return Passos;
    }

    public void setPassos(int passos) {
        Passos = passos;
    }

    public enum StatusParticipacao {
        FINALIZADO,
        DESISTENCIA,
        PARTICIPANDO
    }
}
