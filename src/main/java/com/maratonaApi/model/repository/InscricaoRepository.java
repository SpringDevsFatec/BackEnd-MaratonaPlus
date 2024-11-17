package com.maratonaApi.model.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.maratonaApi.model.Inscricao;
//import com.maratonaApi.model.Maratona;

public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {
	
	//Select todas as maratonas com status Aberta com base no id do corredor 
	//@Query("SELECT m FROM Maratona m JOIN Inscricao i ON m.id_maratona = i.maratona.id_maratona WHERE i.corredor.id_corredor = :idCorredor AND (m.status = 'Aberta para Inscrição' OR m.status = 'Aberta')")
    //List<Maratona> findMaratonasByAbertas(@Param("idCorredor") int idCorredor);
	
	//Lista maratonas concluidas de um determinado corredor
	//@Query("SELECT m FROM Maratona m JOIN Inscricao i ON m.id_maratona = i.maratona.id_maratona WHERE i.corredor.idid_corredor = :idCorredor AND m.status = 'Concluido'")
    //List<Maratona> findMaratonasByConcluidas(@Param("idCorredor") int idCorredor);
	
	//Lista corredores de um determinada maratona
	
	
	//Lista corredores participando de um determinado maratona
	
	
	//Lista corredores participando de um determinado maratona
	
	
	//Lista corredores concluiram certa maratona
	
	
	//atualizar o status da inscricao
}