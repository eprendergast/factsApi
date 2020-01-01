package com.example.randomFactsApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController 
class FactController {

    private final FactRepository repository;

    FactController(FactRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/facts")
    List<Fact> all() {
        return repository.findAll();
    }

    @GetMapping("/facts/{id}")
    Fact one(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new FactNotFoundException(id));
    }

}