package com.maratonaApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ranking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_corredor")
    private int idCorredor;

    @Column(name = "id_maratona")
    private int idMaratona;

    @Column(name = "tempo_total") // Tempo em minutos
    private double tempoTotal;

    @Column(name = "posicao")
    private int posicao;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(double tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}