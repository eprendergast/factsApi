package com.example.randomFactsApi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
class StatusController {

    @RequestMapping("/status")
    public Status status() {
        return new Status();
    }
}