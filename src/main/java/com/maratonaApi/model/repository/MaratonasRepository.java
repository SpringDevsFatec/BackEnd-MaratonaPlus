package com.maratonaApi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maratonaApi.model.Maratona;

public interface MaratonasRepository extends JpaRepository<Maratona, Integer> {
	
	//Lista maratonas com base no status
	List<Maratona> findByStatus(Maratona.StatusMaratona status);
	
	//Lista maratonas por criador
	List<Maratona> findByCriador(Integer criador);
	
}