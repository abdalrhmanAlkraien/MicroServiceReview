package com.ServiceC.ServiceC.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceC.ServiceC.entity.User;
import com.ServiceC.ServiceC.service.ServiceC;

@RestController
@RequestMapping("v1")
public class ServiceCController {
	
	private final ServiceC cService;
	public ServiceCController(ServiceC cService) {
		// TODO Auto-generated constructor stub
		this.cService=cService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok().body(cService.getAllUser());
	}
	

}
