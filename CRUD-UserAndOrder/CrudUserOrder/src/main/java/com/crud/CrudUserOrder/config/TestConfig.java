package com.crud.CrudUserOrder.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.crud.CrudUserOrder.entites.Order;
import com.crud.CrudUserOrder.entites.User;
import com.crud.CrudUserOrder.repositories.OrderRepository;
import com.crud.CrudUserOrder.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private UserRepository userRepo;
	private OrderRepository orderRepo;
	

	public TestConfig(UserRepository userRepo, OrderRepository orderRepo) {
		this.userRepo = userRepo;
		this.orderRepo = orderRepo;
	}

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Otteoke", "Otteoke@chorom.com", "123456", "babochorom");
		User u2 = new User(null, "Jigum", "Jigum@chorom.com", "123456", "nouaham");

		
		Order o1 = new Order(null, Instant.parse("2024-08-01T11:00:15Z"), u1, 1);
		Order o2 = new Order(null, Instant.parse("2024-08-01T11:00:15Z"), u2, 2);
		
		userRepo.saveAll(Arrays.asList(u1, u2));
		orderRepo.saveAll(Arrays.asList(o1, o2));
		
	}

}
