package com.maratonaApi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    private Date dataHora;
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    @Column(name = "status")
    private String status;

    public Inscricao(int idInscricao, int idCorredor, int idMaratona, String formaPagamento, Date dataHora, String status) {
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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
