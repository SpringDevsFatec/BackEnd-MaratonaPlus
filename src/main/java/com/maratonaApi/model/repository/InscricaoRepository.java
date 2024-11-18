package com.maratonaApi.model.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maratonaApi.model.Inscricao;
import com.maratonaApi.model.Maratona;
import com.maratonaApi.model.Corredor;

public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
	
	//Select maratonas com status Aberta com base no id do corredor
	@Query("SELECT m FROM Maratona m JOIN Inscricao i ON m.idMaratona = i.idMaratona WHERE i.idCorredor = :idCorredor AND (m.status = 'Aberta para Inscrição' OR m.status = 'Aberta')")
    List<Maratona> findMaratonasAbertasByIdCorredor(@Param("idCorredor") int idCorredor);
	
	//select maratonas com status concluídas com base no id do corredor
	@Query("SELECT m FROM Maratona m JOIN Inscricao i ON m.idMaratona = i.idMaratona WHERE i.idCorredor = :idCorredor AND m.status = 'Finalizada'")
    List<Maratona> findMaratonasConcluidasByIdCorredor(@Param("idCorredor") int idCorredor);
	
	//select corredores pela tabela de inscrição com status "Inscrito" com base no id da maratona
	@Query("SELECT c FROM Corredor c INNER JOIN Inscricao i ON c.idCorredor = i.idCorredor WHERE i.idMaratona = :idMaratona AND i.status = 'Inscrito'")
	List<Corredor> findCorredoresInscritosByMaratona(@Param("idMaratona") int idMaratona);

	//select corredores pela tabela de inscrição com status "Participando" com base no id da maratona
	@Query("SELECT c FROM Corredor c INNER JOIN Inscricao i ON c.idCorredor = i.idCorredor WHERE i.idMaratona = :idMaratona AND i.status = 'Participando'")
	List<Corredor> findCorredoresParticipandoByMaratona(@Param("idMaratona") int idMaratona);

	//select corredores pela tabela de inscrição com status "Concluido" com base no id da maratona
	@Query("SELECT c FROM Corredor c INNER JOIN Inscricao i ON c.idCorredor = i.idCorredor WHERE i.idMaratona = :idMaratona AND i.status = 'Concluido'")
	List<Corredor> findCorredoresConcluiramByMaratona(@Param("idMaratona") int idMaratona);

}