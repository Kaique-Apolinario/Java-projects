package com.crud.CrudUserOrder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.CrudUserOrder.entites.Category;
import com.crud.CrudUserOrder.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository catRepo;

	public CategoryService(CategoryRepository catRepo) {
		super();
		this.catRepo = catRepo;
	}
	
	public List<Category> findAll(){
		return catRepo.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> category = catRepo.findById(id);
		return category.get();
	}
	
}
