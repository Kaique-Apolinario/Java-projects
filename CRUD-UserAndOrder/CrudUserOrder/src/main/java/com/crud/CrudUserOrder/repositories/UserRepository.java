package com.crud.CrudUserOrder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.CrudUserOrder.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
