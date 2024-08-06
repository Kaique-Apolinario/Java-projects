package com.crud.CrudUserOrder.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CrudUserOrder.entites.Category;
import com.crud.CrudUserOrder.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	private CategoryService catServ;

	public CategoryController(CategoryService catServ) {
		super();
		this.catServ = catServ;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return ResponseEntity.ok().body(catServ.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(catServ.findById(id));
	}
}
