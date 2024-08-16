package com.crud.CrudUserOrder.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.CrudUserOrder.entities.User;
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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User newUser){
		newUser = userServ.insert(newUser);
		return ResponseEntity.ok().body(newUser);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User upUser){
		upUser = userServ.update(id, upUser);
		return ResponseEntity.ok().body(upUser);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userServ.delete(id);
		return ResponseEntity.noContent().build();
				}
}
