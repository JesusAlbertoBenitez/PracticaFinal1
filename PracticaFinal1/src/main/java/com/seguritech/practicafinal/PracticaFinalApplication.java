package com.seguritech.practicafinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.seguritech.MiPracticaFinal.domain.repositories")
public class PracticaFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaFinalApplication.class, args);
	}
}
