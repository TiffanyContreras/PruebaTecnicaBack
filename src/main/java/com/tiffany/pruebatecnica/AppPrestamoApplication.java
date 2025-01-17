package com.tiffany.pruebatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.tiffany.pruebatecnica.repository"})
@EntityScan(basePackages = {"com.tiffany.pruebatecnica.modelo"})
public class AppPrestamoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPrestamoApplication.class, args);
	}

}
