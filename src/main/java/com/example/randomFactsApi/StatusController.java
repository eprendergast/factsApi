package com.example.randomFactsApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
class StatusController {

    private final FactRepository repository;

    StatusController(FactRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/status")
    public Status status() {
        return new Status(repository);
    }
}