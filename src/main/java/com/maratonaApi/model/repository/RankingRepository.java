package com.maratonaApi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maratonaApi.model.Ranking;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer> {

    // Busca o ranking de uma maratona
    List<Ranking> findByIdMaratonaOrderByTempoTotalAsc(int idMaratona);
}