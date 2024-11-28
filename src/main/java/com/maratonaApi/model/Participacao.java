package com.maratonaApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter @Getter
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
    private String tempoRegistrado;
	@Column(name = "tempo_inicio")
    private Timestamp tempoInicio;
    @Column(name = "tempo_ingresso")
    private Timestamp tempoIngresso;
	@Column(name = "tempo_fim")
    private Timestamp tempoFim;
	@Column(name = "passos")
    private int Passos;
    @Column(name = "velocidade_km")
    private float velocidadeKm;
    @Column(name = "velocidade_ms")
    private float velocidadeMs;

    public Participacao() {
    }

    public Participacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public Participacao(int idParticipacao, int idInscricao, String tempoRegistrado, StatusParticipacao statusConclusao, Timestamp tempoInicio, Timestamp tempoIngresso, Timestamp tempoFim, int passos, float velocidadeKm, float velocidadeMs) {
        this.idParticipacao = idParticipacao;
        this.idInscricao = idInscricao;
        this.tempoRegistrado = tempoRegistrado;
        this.statusConclusao = statusConclusao;
        this.tempoInicio = tempoInicio;
        this.tempoIngresso = tempoIngresso;
        this.tempoFim = tempoFim;
        Passos = passos;
        this.velocidadeKm = velocidadeKm;
        this.velocidadeMs = velocidadeMs;
    }
    /*
    public int getIdParticipacao() {
        return idParticipacao;
    }

    public void setIdParticipacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }
     */

    public enum StatusParticipacao {
        FINALIZADO,
        DESISTENCIA,
        PARTICIPANDO
    }
}
