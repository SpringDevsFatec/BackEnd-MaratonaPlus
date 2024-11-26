package com.maratonaApi.model.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maratonaApi.model.Inscricao;
import com.maratonaApi.model.Maratona;
import com.maratonaApi.model.Corredor;

public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
	
	//Select maratonas com status ABERTA OU ABERTA_PARA_INSCRICAO com base no id do corredor
	@Query("SELECT m FROM Maratona m JOIN Inscricao i ON m.idMaratona = i.idMaratona WHERE i.idCorredor = :idCorredor AND (m.status = 'ABERTA' OR m.status = 'ABERTA_PARA_INSCRICAO')")
    List<Maratona> findMaratonasAbertasByIdCorredor(@Param("idCorredor") int idCorredor);
	
	//select maratonas com status CONCLUIDA com base no id do corredor
	@Query("SELECT m FROM Maratona m JOIN Inscricao i ON m.idMaratona = i.idMaratona WHERE i.idCorredor = :idCorredor AND m.status = 'CONCLUIDA'")
    List<Maratona> findMaratonasConcluidasByIdCorredor(@Param("idCorredor") int idCorredor);
	
	//select corredores pela tabela de inscrição com status "INSCRITO" com base no id da maratona
	@Query("SELECT c FROM Corredor c INNER JOIN Inscricao i ON c.idCorredor = i.idCorredor WHERE i.idMaratona = :idMaratona AND i.status = 'INSCRITO'")
	List<Corredor> findCorredoresInscritosByMaratona(@Param("idMaratona") int idMaratona);

	//select corredores pela tabela de inscrição com status "PARTICIPANDO" com base no id da maratona
	@Query("SELECT c FROM Corredor c INNER JOIN Inscricao i ON c.idCorredor = i.idCorredor WHERE i.idMaratona = :idMaratona AND i.status = 'PARTICIPANDO'")
	List<Corredor> findCorredoresParticipandoByMaratona(@Param("idMaratona") int idMaratona);

	//select corredores pela tabela de inscrição com status "FINALIZADO" com base no id da maratona
	@Query("SELECT c FROM Corredor c INNER JOIN Inscricao i ON c.idCorredor = i.idCorredor WHERE i.idMaratona = :idMaratona AND i.status = 'FINALIZADO'")
	List<Corredor> findCorredoresConcluiramByMaratona(@Param("idMaratona") int idMaratona);

	//select corredores pela tabela de inscrição com status "DESISTENCIA" com base no id da maratona
	@Query("SELECT c FROM Corredor c INNER JOIN Inscricao i ON c.idCorredor = i.idCorredor WHERE i.idMaratona = :idMaratona AND i.status = 'DESISTENCIA'")
	List<Corredor> findCorredoresDesitiramByMaratona(@Param("idMaratona") int idMaratona);

	// Busca todas as inscrições de uma maratona específica
	List<Inscricao> findByIdMaratona(Integer idMaratona);

	Optional<Inscricao> findById(int idInscricao);

}