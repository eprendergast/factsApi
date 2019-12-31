package com.example.randomFactsApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
class FactController {

    private final FactRepository repository;

    FactController(FactRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/facts")
    List<Fact> all() {
        return repository.findAll();
    }

    @PostMapping("/facts")
    Fact newFact(@RequestBody Fact newFact) {
        return repository.save(newFact);
    }

    // Single item

    @GetMapping("/facts/{id}")
    Fact one(@PathVariable String id) {

        return repository.findById(id).orElseThrow(() -> new FactNotFoundException(id));
    }

    @PutMapping("/facts/{id}")
    Fact replaceFact(@RequestBody Fact newFact, @PathVariable String id) {

        return repository.findById(id).map(fact -> {
            fact.setId(newFact.getId());
            fact.setText(newFact.getText());
            fact.setUrl(newFact.getUrl());
            fact.setLanguage(newFact.getLanguage());
            return repository.save(fact);
        }).orElseGet(() -> {
            newFact.setId(id);
            return repository.save(newFact);
        });
    }

    @DeleteMapping("/facts/{id}")
    void deleteFact(@PathVariable String id) {
        repository.deleteById(id);
    }
}