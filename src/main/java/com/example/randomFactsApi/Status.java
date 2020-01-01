package com.example.randomFactsApi;

import lombok.Data;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods.
class Status {

    private String status;
    private Long total;
    private Long unique;

    Status(FactRepository repository){
        Long totalFacts = repository.count();
        this.status = totalFacts > 0 ? "COMPLETED" : "ERROR";
        this.total = totalFacts; 
        this.unique = repository.countUnique();
    }
}
