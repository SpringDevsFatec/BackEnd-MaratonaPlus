package com.maratonaApi.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private int idEmpresa;
    private String nome;
    private String telefone;
    private String email;
    private String usuario;
    private String senha;
    private String cnpj;
    private String local;
    @Column(name = "url_logo")
    private String urlLogo;
    @Column(name = "data_criacao")
    private Timestamp dataCriacao;


    public Empresa(int idEmpresa, String nome, String telefone, String email, String usuario, String senha, String cnpj, String local, String urlLogo, Timestamp dataCriacao) {
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.cnpj = cnpj;
        this.local = local;
        this.urlLogo = urlLogo;
        this.dataCriacao = dataCriacao;
    }

    public Empresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa() {
    }

    // Getters e Setters

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public Timestamp getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Timestamp dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
