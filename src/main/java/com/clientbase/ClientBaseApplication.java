package com.clientbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ClientBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientBaseApplication.class, args);
	}

}
