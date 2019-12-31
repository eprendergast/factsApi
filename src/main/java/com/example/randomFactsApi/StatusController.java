package com.example.randomFactsApi;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // indicates that the data returned by each method will be written straight into
                // the response body instead of rendering a template.
class StatusController {

    @RequestMapping("/status")
    public Status status() {
        return new Status();
    }
}

// {
//     “status”: “COMPLETED”, “facts”: {
//     “total”: 1000,
//     “unique”: 256 }
//     }