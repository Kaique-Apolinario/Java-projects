package com.crud.CrudUserOrder.entites;

import java.io.Serializable;
import java.util.Objects;

import com.crud.CrudUserOrder.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//OrderItem attributes
	@EmbeddedId
	private OrderItemPK idpk;
	private Integer quantity;
	private Double price;
	
	//OrderItem constructors
	public OrderItem(){}
	
	public OrderItem(Product prod, Order order, Integer quantity, Double price) {
		super();
		this.idpk = new OrderItemPK(prod, order);
		this.quantity = quantity;
		this.price = price;
	}
	
	//OrderItem getters and setters
	public OrderItemPK getIdpk() {
		return idpk;
	}

	public void setIdpk(OrderItemPK idpk) {
		this.idpk = idpk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	//OrderItem hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(idpk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(idpk, other.idpk);
	}
	
	
}