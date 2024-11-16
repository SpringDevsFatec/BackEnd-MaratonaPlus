package com.maratonaApi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maratonaApi.model.Maratona;

public interface MaratonasRepository extends JpaRepository<Maratona, Integer> {
	
	//lista maratonas com base no status
	List<Maratona> findByStatus(String status);
	
	//lista maratonas por criador
	List<Maratona> findByCriador(Integer criador);
	
}