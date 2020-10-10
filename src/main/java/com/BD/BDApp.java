package com.BD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BDApp {

	public static void main(String[] args) {
		SpringApplication.run(BDApp.class, args);
	}

}
