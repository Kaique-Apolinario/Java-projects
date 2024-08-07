package com.crud.CrudUserOrder.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Product attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	
	@OneToMany(mappedBy = "idpk.prod_id")
	private Set<OrderItem> items= new HashSet<>();
	
	@ManyToMany(mappedBy = "prodList")
	private Set<Category> catList= new HashSet<>();
	
	
	//Product constructors
	public Product() {
		super();
	}

	public Product(Long id, String name, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	//Product getters and setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Set<Category> getCatList() {
		return catList;
	}
	
	public Set<Order> getOrders(){
		Set<Order> orders = new HashSet<>();
		for (OrderItem order : items) {
			orders.add(order.getOrder());
		}
		return orders;
	}
	
	
	//Product hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
}
