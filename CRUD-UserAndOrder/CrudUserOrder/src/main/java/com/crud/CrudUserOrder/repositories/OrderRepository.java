package com.crud.CrudUserOrder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.CrudUserOrder.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
