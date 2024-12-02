package com.maratonaApi.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
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
    private LocalDateTime dataHora;
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

    /*
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
     */

    public enum StatusInscricao {
        INSCRITO,
        PARTICIPANDO,
        FINALIZADO,
        DESISTENCIA
    }
}
