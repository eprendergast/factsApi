package com.example.randomFactsApi;

import lombok.Data;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields.
// @Entity // JPA annotation to make this object ready for storage in a JPA-based data store.
class Status {

    private String status;
    private Integer total;
    private Integer unique;

    Status(){
        this.status = "COMPLETED";
        this.total = 1000; 
        this.unique = 256;
    }
}
