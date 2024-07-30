package com.crud.CrudUserOrder.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.CrudUserOrder.entites.User;
import com.crud.CrudUserOrder.repositories.UserRepository;

@Service
public class UserService {

	
	UserRepository userRepo;
	
	public List<User> findAll () {
		return userRepo.findAll();
	}
}
