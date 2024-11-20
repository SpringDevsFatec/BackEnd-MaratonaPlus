package com.maratonaApi.model;

import java.time.LocalDate;  // Usar LocalDate para data sem hora
import java.time.LocalDateTime;  // Usar LocalDateTime para data e hora
import jakarta.persistence.*;

@Entity
@Table(name = "inscricao")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscricao")
    private int idInscricao;

    @Column(name = "id_corredor")
    private int idCorredor;

    @Column(name = "id_maratona")
    private int idMaratona;

    @Column(name = "data_hora")
    private LocalDateTime dataHora; // Usando LocalDateTime para data e hora de inscrição

    @Column(name = "forma_pagamento")
    private String formaPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusInscricao status;

    @Column(name = "data_participacao")
    private LocalDate dataParticipacao;  // Usando LocalDate para data de participação (sem hora)

    // Getters e Setters
    public int getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(int idInscricao) {
        this.idInscricao = idInscricao;
    }

    public int getIdCorredor() {
        return idCorredor;
    }

    public void setIdCorredor(int idCorredor) {
        this.idCorredor = idCorredor;
    }

    public int getIdMaratona() {
        return idMaratona;
    }

    public void setIdMaratona(int idMaratona) {
        this.idMaratona = idMaratona;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusInscricao getStatus() {
        return status;
    }

    public void setStatus(StatusInscricao status) {
        this.status = status;
    }

    public LocalDate getDataParticipacao() {
        return dataParticipacao;
    }

    public void setDataParticipacao(LocalDate dataParticipacao) {
        this.dataParticipacao = dataParticipacao;
    }

    public enum StatusInscricao {
        INSCRITO,
        PARTICIPANDO,
        FINALIZADO,
        DESISTENCIA
    }
}
