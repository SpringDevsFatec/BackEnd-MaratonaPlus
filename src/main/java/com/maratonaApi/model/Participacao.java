package com.maratonaApi.model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "participacao")
public class Participacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_participacao")
	private int idParticipacao;
	@Column(name = "id_inscricao")
    private int idInscricao;
	@Column(name = "status_conclusao")
    private String statusConclusao;
	@Column(name = "tempo_registrado")
    private Time tempoRegistrado;
	@Column(name = "tempo_inicio")
    private Time tempoInicio;
	@Column(name = "tempo_fim")
    private Time tempoFim;
	@Column(name = "passos")
    private int Passos;

    public Participacao() {
    }

    public Participacao(int idParticipacao) {
        this.idParticipacao = idParticipacao;
    }

    public Participacao(int idParticipacao, int idInscricao, String statusConclusao, Time tempoRegistrado, Time tempoFim, Time tempoInicio, int passos) {
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

    public Time getTempoRegistrado() {
        return tempoRegistrado;
    }

    public void setTempoRegistrado(Time tempoRegistrado) {
        this.tempoRegistrado = tempoRegistrado;
    }

    public String getStatusConclusao() {
        return statusConclusao;
    }

    public void setStatusConclusao(String statusConclusao) {
        this.statusConclusao = statusConclusao;
    }

    public Time getTempoInicio() {
        return tempoInicio;
    }

    public void setTempoInicio(Time tempoInicio) {
        this.tempoInicio = tempoInicio;
    }

    public Time getTempoFim() {
        return tempoFim;
    }

    public void setTempoFim(Time tempoFim) {
        this.tempoFim = tempoFim;
    }

    public int getPassos() {
        return Passos;
    }

    public void setPassos(int passos) {
        Passos = passos;
    }
}
