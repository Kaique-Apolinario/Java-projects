package com.crud.CrudUserOrder.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CrudUserOrder.entities.Product;
import com.crud.CrudUserOrder.services.ProductService;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	private ProductService prodServ;
	
	public ProductController(ProductService prodServ){
		this.prodServ = prodServ;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = prodServ.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(prodServ.findById(id));
	}
	
}
