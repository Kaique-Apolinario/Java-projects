package com.crud.CrudUserOrder.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CrudUserOrder.entities.Order;
import com.crud.CrudUserOrder.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	private OrderService orderServ;

	public OrderController(OrderService orderServ){
		this.orderServ = orderServ;
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = orderServ.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(orderServ.findById(id));
	}
}
