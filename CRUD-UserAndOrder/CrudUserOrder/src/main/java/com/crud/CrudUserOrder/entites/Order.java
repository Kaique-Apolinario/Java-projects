package com.crud.CrudUserOrder.entites;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.crud.CrudUserOrder.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Order attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:hh:ss'Z'", timezone= "GMT")
	private Instant moment;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private OrderStatus orderStatus;
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	@OneToMany(mappedBy = "idpk.order_id")
	private Set<OrderItem> items = new HashSet<>();
	
	
	
	
	
	

	
	//Order constructors
	public Order() {
	}

	public Order(Long id, Instant moment, User user, int orderStatusNumber) {
		super();
		this.id = id;
		this.moment = moment;
		this.user = user;
		orderStatus = OrderStatus.convertIntToStatus(orderStatusNumber);
	}

	//Order getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getOrderStatus() {
		return orderStatus.getNum();
	}

	public void setOrderStatus(int num) {
		orderStatus = OrderStatus.convertIntToStatus(num);
	}

	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}

	//Order hashcode and equalsTo
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	

}
