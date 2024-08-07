package com.crud.CrudUserOrder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.CrudUserOrder.entities.OrderItem;
import com.crud.CrudUserOrder.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
