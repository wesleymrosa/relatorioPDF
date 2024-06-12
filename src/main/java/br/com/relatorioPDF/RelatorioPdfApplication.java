package br.com.relatorioPDF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RelatorioPdfApplication {

	public static void main(String[] args) {

		SpringApplication.run(RelatorioPdfApplication.class, args);

		new PrimeiroPDF("terceiro arquivo do projeto.");
	}

}
