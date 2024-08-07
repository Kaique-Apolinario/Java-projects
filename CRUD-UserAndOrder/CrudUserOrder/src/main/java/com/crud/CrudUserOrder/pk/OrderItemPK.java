package com.crud.CrudUserOrder.pk;

import java.util.Objects;

import com.crud.CrudUserOrder.entities.Order;
import com.crud.CrudUserOrder.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPK {

	//OrderItemPK attributes
	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Product prod_id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order_id;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//OrderItemPK constructors
	public OrderItemPK() {
	}
	
	public OrderItemPK(Product prod_id, Order order_id) {
		super();
		this.prod_id = prod_id;
		this.order_id = order_id;
	}
	

	//OrderItemPK
	public Product getProd_id() {
		return prod_id;
	}

	public void setProd_id(Product prod_id) {
		this.prod_id = prod_id;
	}

	public Order getOrder_id() {
		return order_id;
	}



	public void setOrder_id(Order order_id) {
		this.order_id = order_id;
	}



	@Override
	public int hashCode() {
		return Objects.hash(order_id, prod_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order_id, other.order_id) && Objects.equals(prod_id, other.prod_id);
	}
	
	
	
}
