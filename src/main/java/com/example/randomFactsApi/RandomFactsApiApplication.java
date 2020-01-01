package com.example.randomFactsApi;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@SpringBootApplication
@Slf4j
public class RandomFactsApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RandomFactsApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate, FactRepository repository) throws Exception {
		return args -> {

			for(int i = 0; i < 100; i ++){
				Fact fact = restTemplate.getForObject("https://uselessfacts.jsph.pl/random.json?language=en", Fact.class);
				repository.save(fact);
				log.info(fact.toString());
			}

		};
	}

}
