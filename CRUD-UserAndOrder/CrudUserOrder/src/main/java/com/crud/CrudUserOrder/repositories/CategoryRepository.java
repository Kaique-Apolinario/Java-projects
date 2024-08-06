package com.crud.CrudUserOrder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.CrudUserOrder.entites.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
