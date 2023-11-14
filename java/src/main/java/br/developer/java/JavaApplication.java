package br.developer.java;

import org.springframework.boot.SpringApplication; // Importa a classe SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa a anotação @SpringBootApplication

@SpringBootApplication // Anotação que combina @Configuration, @EnableAutoConfiguration e
						// @ComponentScan
public class JavaApplication { // Classe principal do Spring Boot

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args); // Inicializa a aplicação Spring Boot
	}

}
