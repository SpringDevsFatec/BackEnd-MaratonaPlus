package com.maratonaApi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "corredor")
public class Corredor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_corredor")
	private int idCorredor;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    @Column(name = "data_nasc")
    private Date dataNascimento;
    private String cpf;
    private String endereco;
    @Column(name = "url_foto")
    private String urlFoto;
    @Column(name = "pais_origem")
    private String paisOrigem;
    private String genero;
    
	@Override
	public String toString() {
		return "Corredores [nome=" + nome + "]";
	}

	public Corredor(int idCorredor, String nome, String telefone, String email, String senha, Date dataNascimento,
			String cpf, String endereco, String urlFoto, String paisOrigem, String genero) {
		super();
		this.idCorredor = idCorredor;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.endereco = endereco;
		this.urlFoto = urlFoto;
		this.paisOrigem = paisOrigem;
		this.genero = genero;
	}
    
	public Corredor(int idCorredor) {
        this.idCorredor = idCorredor;
    }

    public Corredor() {
    }
    
    //Getters e Setters

	public int getIdCorredor() {
		return idCorredor;
	}

	public void setIdCorredor(int idCorredor) {
		this.idCorredor = idCorredor;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
    
}
