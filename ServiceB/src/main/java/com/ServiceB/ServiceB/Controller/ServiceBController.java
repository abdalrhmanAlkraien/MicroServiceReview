package com.ServiceB.ServiceB.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceB.ServiceB.Entity.User;
import com.ServiceB.ServiceB.Service.BService;

@RestController
@RequestMapping("v1")
public class ServiceBController {
	
	private final BService bService;
	
	public ServiceBController(BService bService) {
			this.bService=bService;
	}
	
	@GetMapping(value = "user")
	public ResponseEntity<List<User>> getAllUser(){
		
		return ResponseEntity.ok().body(bService.getAllUser());
	} 
	
	@PostMapping("user")
	public ResponseEntity<User> createNewUser(@RequestBody User user){
		return ResponseEntity.ok().body(bService.createNewUser(user));

	}

}
