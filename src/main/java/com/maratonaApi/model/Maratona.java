package com.maratonaApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "maratona")
public class Maratona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maratona")
    private int idMaratona;
	@Setter @Getter
    private int criador;
	@Setter @Getter
    private String nome;
	@Setter @Getter
    private String local;
    @Setter @Getter
    @Column(name = "data_inicio")
    private LocalDate dataInicio;
    @Setter @Getter
    @Column(name = "data_final")
    private LocalDate dataFinal;
    @Setter @Getter
    @Enumerated(EnumType.STRING)
    private StatusMaratona status;
    @Setter @Getter
    private String distancia;
    @Setter @Getter
    private String descricao;
    @Setter @Getter
    @Column(name = "limite_participantes")
    private int limiteParticipantes;
    @Setter @Getter
    private String regras;
    @Setter @Getter
    private float valor;
    @Setter @Getter
    @Column(name = "tipo_terreno")
    private String tipoTerreno;
    @Setter @Getter
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

    public Maratona(int id, int criador, String nome, String local, LocalDate dataInicio, LocalDate dataFinal, StatusMaratona status, String distancia, String descricao, String regras, int limiteParticipantes, float valor, String climaEsperado, String tipoTerreno) {
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

    // Metodo para verificar se a maratona está aberta para inscrição
    public boolean isAbertaParaInscricao() {
        return this.status == StatusMaratona.ABERTA_PARA_INSCRICAO || this.status == StatusMaratona.ABERTA;
    }

    // Metodo para verificar se a maratona está em andamento
    public boolean isEmAndamento() {
        return this.status == StatusMaratona.EM_ANDAMENTO;
    }

    // Metodo para verificar se a maratona está concluída
    public boolean isFinalizada() {
        return this.status == StatusMaratona.CONCLUIDA;
    }
    // Metodo para verificar se a maratona foi cancelada
    public boolean isCancelada() {
        return this.status == StatusMaratona.CANCELADA;
    }
    // Enum com os status possíveis da maratona
    public enum StatusMaratona {
        ABERTA_PARA_INSCRICAO,
        ABERTA,
        EM_ANDAMENTO,
        CONCLUIDA,
        CANCELADA
    }
}
