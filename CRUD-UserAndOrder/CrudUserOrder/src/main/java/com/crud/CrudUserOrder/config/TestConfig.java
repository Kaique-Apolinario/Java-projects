package com.crud.CrudUserOrder.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.crud.CrudUserOrder.entites.Order;
import com.crud.CrudUserOrder.entites.OrderItem;
import com.crud.CrudUserOrder.entites.Payment;
import com.crud.CrudUserOrder.entites.Product;
import com.crud.CrudUserOrder.entites.User;
import com.crud.CrudUserOrder.repositories.OrderItemRepository;
import com.crud.CrudUserOrder.repositories.OrderRepository;
import com.crud.CrudUserOrder.repositories.ProductRepository;
import com.crud.CrudUserOrder.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private UserRepository userRepo;
	private OrderRepository orderRepo;
	private ProductRepository prodRepo;
	private OrderItemRepository oiRepo;
	
	//Dependency constructor
	public TestConfig(UserRepository userRepo, OrderRepository orderRepo, ProductRepository prodRepo, OrderItemRepository oiRepo) {
		this.userRepo = userRepo;
		this.orderRepo = orderRepo;
		this.prodRepo = prodRepo;
		this.oiRepo = oiRepo;
	}

	//Test instantiations
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Otteoke", "Otteoke@chorom.com", "123456", "babochorom");
		User u2 = new User(null, "Jigum", "Jigum@chorom.com", "123456", "nouaham");

		
		Order o1 = new Order(null, Instant.parse("2024-08-01T11:00:15Z"), u1, 1);
		Order o2 = new Order(null, Instant.parse("2024-08-01T11:00:15Z"), u2, 2);
		
		userRepo.saveAll(Arrays.asList(u1, u2));
		orderRepo.saveAll(Arrays.asList(o1, o2));
		
		Payment p1 = new Payment(null, Instant.parse("2024-08-01T11:00:15Z"), o1);
		o1.setPayment(p1);
		orderRepo.save(o1);
		
		Product prod1 = new Product(null, "Shampoo", "Use on your hair", 10.2);
		Product prod2 = new Product(null, "Spoon", "Use to eat", 5.0);
		Product prod3 = new Product(null, "Smartphone", "Use for your entertainment", 900.5);
		
		prodRepo.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		OrderItem oi1 = new OrderItem(prod1, o1, 2, prod1.getPrice());
		OrderItem oi2 = new OrderItem(prod2, o1, 2, prod2.getPrice());
		OrderItem oi3 = new OrderItem(prod3, o2, 2, prod3.getPrice());
		OrderItem oi4 = new OrderItem(prod3, o2, 3, prod3.getPrice());
		
		oiRepo.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		
	}

}
