package com.crud.CrudUserOrder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.CrudUserOrder.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
