package com.maratonaApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "maratona")
public class Maratona {
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maratona")
    private int idMaratona;
	@Setter
    @Getter
    private int criador;
	@Setter
    @Getter
    private String nome;
	@Setter
    @Getter
    private String local;
    @Setter
    @Getter
    @Column(name = "data_inicio")
    private String dataInicio;
    @Setter
    @Getter
    @Column(name = "data_final")
    private String dataFinal;
    @Setter
    @Getter
    private String status;
    @Setter
    @Getter
    private String distancia;
    @Setter
    @Getter
    private String descricao;
    @Setter
    @Getter
    @Column(name = "limite_participantes")
    private int limiteParticipantes;
    @Setter
    @Getter
    private String regras;
    @Setter
    @Getter
    private float valor;
    @Setter
    @Getter
    @Column(name = "tipo_terreno")
    private String tipoTerreno;
    @Setter
    @Getter
    @Column(name = "clima_esperado")
    private String climaEsperado;

    @Override
	public String toString() {
		return "Maratonas [Nome=" + nome + "]";
	}

    public Maratona() {
    }

    public Maratona(int id) {
        this.idMaratona = id;
    }

    public Maratona(int id, int criador, String nome, String local, String dataInicio, String dataFinal, String status, String distancia, String descricao, String regras, int limiteParticipantes, float valor, String climaEsperado, String tipoTerreno) {
        this.idMaratona = id;
        this.criador = criador;
        this.nome = nome;
        this.local = local;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.status = status;
        this.distancia = distancia;
        this.descricao = descricao;
        this.regras = regras;
        this.limiteParticipantes = limiteParticipantes;
        this.valor = valor;
        this.climaEsperado = climaEsperado;
        this.tipoTerreno = tipoTerreno;
    }

    public int getId() {
        return this.idMaratona;
    }

    public void setId(int id) {
        this.idMaratona = id;
    }

}
