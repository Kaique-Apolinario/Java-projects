package com.crud.CrudUserOrder.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CrudUserOrder.entites.User;
import com.crud.CrudUserOrder.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService userServ;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userServ.findAll();
		return ResponseEntity.ok().body(list);
	}

}