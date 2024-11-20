package com.maratonaApi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maratonaApi.model.Inscricao;
import com.maratonaApi.model.Maratona;
import com.maratonaApi.model.Inscricao.StatusInscricao;

public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {

	// Select todas as maratonas abertas com base no id do corredor
	@Query("SELECT m FROM Maratona m JOIN Inscricao i ON m.idMaratona = i.idMaratona WHERE i.idCorredor = :idCorredor AND (m.status = 'Aberta para Inscrição' OR m.status = 'Aberta')")
	List<Maratona> findMaratonasAbertasByIdCorredor(@Param("idCorredor") int idCorredor);

	// Lista maratonas concluídas de um determinado corredor
	@Query("SELECT m FROM Maratona m JOIN Inscricao i ON m.idMaratona = i.idMaratona WHERE i.idCorredor = :idCorredor AND m.status = 'Finalizada'")
	List<Maratona> findMaratonasConcluidasByIdCorredor(@Param("idCorredor") int idCorredor);

	// Retorna as inscrições de maratonas com status PARTICIPANDO
	@Query("SELECT i FROM Inscricao i WHERE i.status = :status")
	List<Inscricao> findByStatusParticipando(@Param("status") StatusInscricao status);

	// Retorna as inscrições de maratonas com status DESISTENCIA
	@Query("SELECT i FROM Inscricao i WHERE i.status = :status")
	List<Inscricao> findByStatusDesistencia(@Param("status") StatusInscricao status);

	// Lista corredores participando de uma maratona específica
	@Query("SELECT i FROM Inscricao i WHERE i.idMaratona = :idMaratona AND i.status = :status")
	List<Inscricao> findCorredoresParticipandoPorMaratona(@Param("idMaratona") int idMaratona, @Param("status") StatusInscricao status);

	// Lista corredores que concluíram uma maratona específica
	@Query("SELECT i FROM Inscricao i WHERE i.idMaratona = :idMaratona AND i.status = :status")
	List<Inscricao> findCorredoresConcluíramPorMaratona(@Param("idMaratona") int idMaratona, @Param("status") StatusInscricao status);
}
