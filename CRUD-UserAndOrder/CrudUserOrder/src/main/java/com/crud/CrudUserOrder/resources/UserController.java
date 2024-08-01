package com.crud.CrudUserOrder.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CrudUserOrder.entites.User;
import com.crud.CrudUserOrder.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	private UserService userServ;
	
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userServ.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(userServ.findbyId(id));
	}

}
