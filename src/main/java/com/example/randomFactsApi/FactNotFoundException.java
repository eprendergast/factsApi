package com.example.randomFactsApi;

class FactNotFoundException extends RuntimeException {

    FactNotFoundException(String id) {
        super("Could not find fact " + id);
    }
}