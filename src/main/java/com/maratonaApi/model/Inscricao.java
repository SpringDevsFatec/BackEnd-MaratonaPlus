package com.maratonaApi.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inscricao")
public class Inscricao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inscricao")
	private int idInscricao;
    @Setter @Getter
	@Column(name = "id_corredor")
    private int idCorredor;
    @Setter @Getter
	@Column(name = "id_maratona")
    private int idMaratona;
    @Setter @Getter
	@Column(name = "data_hora")
    private LocalDateTime dataHora;
    @Setter @Getter
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusInscricao status;

    public Inscricao(int idInscricao, int idCorredor, int idMaratona, String formaPagamento, LocalDateTime dataHora, StatusInscricao status) {
        this.idInscricao = idInscricao;
        this.idCorredor = idCorredor;
        this.idMaratona = idMaratona;
        this.formaPagamento = formaPagamento;
        this.dataHora = dataHora;
        this.status = status;
    }

    public Inscricao(int idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Inscricao() {
    }

    // Getters e Setters
    public int getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(int idInscricao) {
        this.idInscricao = idInscricao;
    }

    public StatusInscricao getStatus() {
        return status;
    }

    public void setStatus(StatusInscricao status) {
        this.status = status;
    }

    public enum StatusInscricao {
        INSCRITO,
        PARTICIPANDO,
        FINALIZADO,
        DESISTENCIA
    }
}
