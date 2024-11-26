package com.maratonaApi.model.repository;

import java.util.List;

import com.maratonaApi.dto.MaratonaComEmpresaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maratonaApi.model.Maratona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaratonasRepository extends JpaRepository<Maratona, Integer> {

	@Query("SELECT new com.maratonaApi.dto.MaratonaComEmpresaDTO(m, e.nome) FROM Maratona m JOIN Empresa e ON m.criador = e.idEmpresa WHERE m.idMaratona = :id")
	MaratonaComEmpresaDTO findMaratonaWithEmpresa(@Param("id") Integer id);

	//Lista maratonas com base no status
	List<Maratona> findByStatus(Maratona.StatusMaratona status);

	//Lista maratonas por criador
	List<Maratona> findByCriador(Integer criador);

}