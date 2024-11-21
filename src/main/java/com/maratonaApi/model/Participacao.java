package com.maratonaApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "participacao")
public class Participacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_participacao")
	private int idParticipacao;
    @Setter @Getter
	@Column(name = "id_inscricao")
    private int idInscricao;
    @Setter @Getter
    @Enumerated(EnumType.STRING)
	@Column(name = "status_conclusao")
    private StatusParticipacao statusConclusao;
    @Setter @Getter
	@Column(name = "tempo_registrado")
    private String tempoRegistrado;
    @Setter @Getter
	@Column(name = "tempo_inicio")
    private Timestamp tempoInicio;
    @Setter @Getter
	@Column(name = "tempo_fim")
    private Timestamp tempoFim;
    @Setter @Getter
	@Column(name = "passos")
    private int Passos;

    public Participacao() {
    }

    public Participacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public Participacao(int idParticipacao, int idInscricao, StatusParticipacao statusConclusao, String tempoRegistrado, Timestamp tempoFim, Timestamp tempoInicio, int passos) {
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

    public enum StatusParticipacao {
        FINALIZADO,
        DESISTENCIA,
        PARTICIPANDO
    }
}
