package com.example.randomFactsApi;

import org.springframework.data.jpa.repository.JpaRepository;

// Extends Spring Data JPA’s JpaRepository, specifying the domain type as Employee and the id type as Long. 

interface FactRepository extends JpaRepository<Fact, String> {

}

// This interface, though empty on the surface, packs a punch given it supports:
    // Creating new instances
    // Updating existing ones
    // Deleting
    // Finding (one, all, by simple or complex properties)