package com.crud.CrudUserOrder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crud.CrudUserOrder.entities.User;
import com.crud.CrudUserOrder.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<User> findAll () {
		return userRepo.findAll();
	}
	
	public User findbyId(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		return optUser.get();
	}
}
