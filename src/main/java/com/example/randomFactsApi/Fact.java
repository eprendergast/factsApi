package com.example.randomFactsApi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields.
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store.
class Fact {

    @Id 
    private String id;

    @Column(length = 1000)
    private String text;

    @Column
    private String source_url;

    @Column
    private String language;

    Fact(){}

    Fact(String id, String text, String source_url, String language){
        this.id = id;
        this.text = text;
        this.source_url = source_url;
        this.language = language;
    }
}