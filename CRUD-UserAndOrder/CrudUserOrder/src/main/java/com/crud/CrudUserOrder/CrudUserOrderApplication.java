package com.crud.CrudUserOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.crud.CrudUserOrder.repositories")
public class CrudUserOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUserOrderApplication.class, args);
	}

}
