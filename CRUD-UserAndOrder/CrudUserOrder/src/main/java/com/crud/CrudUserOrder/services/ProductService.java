package com.crud.CrudUserOrder.services;

import java.util.List;
import java.util.Optional;

import com.crud.CrudUserOrder.entites.Product;
import com.crud.CrudUserOrder.repositories.ProductRepository;

public class ProductService {
	
	private ProductRepository prodRepo;
	
	public ProductService(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}
	
	public List<Product> findAll(){
		return prodRepo.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> prod = prodRepo.findById(id);
		return prod.get();
	}
	
	
}
