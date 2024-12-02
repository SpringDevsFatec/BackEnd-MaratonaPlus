package com.maratonaApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "maratona")
@Setter @Getter
public class Maratona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maratona")
    private int idMaratona;
    private int criador;
    private String nome;
    private String local;
    @Column(name = "data_inicio")
    private String data_inicio;
    @Column(name = "data_final")
    private String data_final;
    @Enumerated(EnumType.STRING)
    private StatusMaratona status;
    private String distancia;
    private String descricao;
    @Column(name = "limite_participantes")
    private int limite_participantes;
    private String regras;
    private float valor;
    @Column(name = "tipo_terreno")
    private String tipo_terreno;
    @Column(name = "clima_esperado")
    private String clima_esperado;

    @Override
	public String toString() {
		return "Maratonas [Nome=" + nome + "]";
	}

    public Maratona() {
    }

    public Maratona(int id) {
        this.idMaratona = id;
    }

    public Maratona(int id, int criador, String nome, String local, String data_inicio, String data_final, StatusMaratona status, String distancia, String descricao, String regras, int limite_participantes, float valor, String clima_esperado, String tipo_terreno) {
        this.idMaratona = id;
        this.criador = criador;
        this.nome = nome;
        this.local = local;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.status = status;
        this.distancia = distancia;
        this.descricao = descricao;
        this.regras = regras;
        this.limite_participantes = limite_participantes;
        this.valor = valor;
        this.clima_esperado = clima_esperado;
        this.tipo_terreno = tipo_terreno;
    }
/*
    public int getId() {
        return this.idMaratona;
    }

    public void setId(int id) {
        this.idMaratona = id;
    }

    // Metodo para verificar se a maratona está aberta para inscrição
    public boolean isAbertaParaInscricao() {
        return this.status == StatusMaratona.ABERTA_PARA_INSCRICAO || this.status == StatusMaratona.ABERTA;
    }

    Metodo para verificar se a maratona está em andamento
  //  public boolean isEmAndamento() {
    //    return this.status == StatusMaratona.EM_ANDAMENTO;
   // }

    // Metodo para verificar se a maratona está concluída
    public boolean isFinalizada() {
        return this.status == StatusMaratona.CONCLUIDA;
    }
    // Metodo para verificar se a maratona foi cancelada
    public boolean isCancelada() {
        return this.status == StatusMaratona.CANCELADA;
    }*/
    // Enum com os status possíveis da maratona
    public enum StatusMaratona {
        ABERTA_PARA_INSCRICAO,
        ABERTA,
        EM_ANDAMENTO,
        CONCLUIDA,
        CANCELADA
    }
}
