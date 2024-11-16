package com.maratonaApi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maratonaApi.model.Corredor;

public interface CorredoresRepository extends JpaRepository<Corredor, Integer> {
	
	//lista de qualquer corredor pelo nome
	List<Corredor> findByNomeContains(String nome);
	
	//busca o corredor por email
	Corredor findByEmail(String email);
}