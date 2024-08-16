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
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findbyId(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		return optUser.get();
	}

	public User insert(User obj) {
		return userRepo.save(obj);
	}
	
	public User update(Long id, User upUser) {
		User entity = userRepo.getReferenceById(id);
		updateData(entity, upUser);
		return userRepo.save(entity);
	}
	
	private void updateData(User entity, User upUser){
		entity.setName(upUser.getName());
		entity.setEmail(upUser.getEmail());
		entity.setPhone(upUser.getPhone());
	}
	
	public void delete(Long id){
		userRepo.deleteById(id);
	}
	
}
