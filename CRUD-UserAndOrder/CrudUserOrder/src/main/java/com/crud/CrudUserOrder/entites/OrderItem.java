package com.crud.CrudUserOrder.entites;

import java.util.Objects;

import com.crud.CrudUserOrder.pk.OrderItemPK;

public class OrderItem {

	private OrderItemPK idpk;
	private Integer quantity;
	private Double price;
	
	public OrderItem(){}
	
	public OrderItem(Product prod, Order order, Integer quantity, Double price) {
		super();
		this.idpk = new OrderItemPK(prod, order);
		this.quantity = quantity;
		this.price = price;
	}
	
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
