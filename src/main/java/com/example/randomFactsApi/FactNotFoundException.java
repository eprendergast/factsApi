package com.example.randomFactsApi;

class FactNotFoundException extends RuntimeException {

    FactNotFoundException(final String id) {
        super("Could not find fact " + id);
    }
}