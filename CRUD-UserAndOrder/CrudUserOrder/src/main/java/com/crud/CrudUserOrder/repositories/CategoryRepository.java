package com.crud.CrudUserOrder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.CrudUserOrder.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
