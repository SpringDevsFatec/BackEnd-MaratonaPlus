package com.maratonaApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "maratona")
public class Maratona {
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maratona")
    private int idMaratona;
	@Column(name = "criador")
    private int criador;
	@Column(name = "nome")
    private String nome;
	@Column(name = "local")
    private String local;
    @Column(name = "data_inicio")
    private String dataInicio;
    @Column(name = "data_final")
    private String dataFinal;
    @Column(name = "status")
    private String status;
    @Column(name = "distancia")
    private String distancia;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "limite_participantes")
    private int limiteParticipantes;
    @Column(name = "regras")
    private String regras;
    @Column(name = "valor")
    private float valor;
    @Column(name = "tipo_terreno")
    private String tipoTerreno;
    @Column(name = "clima_esperado")
    private String climaEsperado;
    @Column(name = "nome_criador")
    private String nomeCriador;

    @Override
	public String toString() {
		return "Maratonas [Nome=" + nome + "]";
	}

    public Maratona() {
    }

    public Maratona(int id) {
        this.idMaratona = id;
    }

    public Maratona(int id, int criador, String nome, String local, String dataInicio, String dataFinal, String status, String distancia, String descricao, String regras, int limiteParticipantes, float valor, String climaEsperado, String tipoTerreno, String nomeCriador) {
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
        this.nomeCriador = nomeCriador;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }

    public int getId() {
        return this.idMaratona;
    }

    public void setId(int id) {
        this.idMaratona = id;
    }

    public int getCriador() {
        return criador;
    }

    public void setCriador(int criador) {
        this.criador = criador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String data_final) {
        this.dataFinal = data_final;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String data_inicio) {
        this.dataInicio = data_inicio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getLimiteParticipantes() {
        return limiteParticipantes;
    }

    public void setLimiteParticipantes(int limite_participantes) {
        this.limiteParticipantes = limite_participantes;
    }

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public void setTipoTerreno(String tipo_terreno) {
        this.tipoTerreno = tipo_terreno;
    }

    public String getClimaEsperado() {
        return climaEsperado;
    }

    public void setClimaEsperado(String clima_esperado) {
        this.climaEsperado = clima_esperado;
    }
}
