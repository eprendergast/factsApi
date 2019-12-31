package com.example.randomFactsApi;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(FactRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Fact("1", "Lorem ipsum", "www.google.ca", "en")));
      log.info("Preloading " + repository.save(new Fact("2", "Lorem ipsum", "wwww.facebook.com", "en")));
    };
  }
}

// id, text, url, language