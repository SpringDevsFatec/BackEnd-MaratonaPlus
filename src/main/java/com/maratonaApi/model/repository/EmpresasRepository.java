package com.maratonaApi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maratonaApi.model.Empresa;

public interface EmpresasRepository extends JpaRepository<Empresa, Integer> {
	
	List<Empresa> findByNomeContains(String nome);
	
	Empresa findByEmail(String email);
}