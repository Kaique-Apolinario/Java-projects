package com.crud.CrudUserOrder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.CrudUserOrder.entities.Order;
import com.crud.CrudUserOrder.repositories.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepo;
	
	public OrderService(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	public List<Order> findAll(){
		return orderRepo.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> optOrd = orderRepo.findById(id);
		return optOrd.get();
	}
}
