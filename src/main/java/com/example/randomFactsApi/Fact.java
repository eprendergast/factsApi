package com.example.randomFactsApi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data // Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields.
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store.
class Fact {

    private @Id String id;
    private String text;
    private String source_url;
    private String language;

    Fact(){}

    Fact(String id, String text, String source_url, String language){
        this.id = id;
        this.text = text;
        this.source_url = source_url;
        this.language = language;
    }
}