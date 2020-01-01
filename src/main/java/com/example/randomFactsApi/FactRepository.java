package com.example.randomFactsApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface FactRepository extends JpaRepository<Fact, String> {

    @Query("SELECT COUNT(id) FROM Fact id")
    long count();

    @Query("SELECT COUNT(DISTINCT id) FROM Fact id")
    long countUnique();

}