package com.example.randomFactsApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // indicates that the data returned by each method will be written straight into
                // the response body instead of rendering a template.
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