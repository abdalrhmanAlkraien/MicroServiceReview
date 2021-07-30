package com.ServiceA.ServiceA.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.ServiceA.ServiceA.Entity.Student;
import com.ServiceA.ServiceA.Entity.User;
import com.ServiceA.ServiceA.Service.AService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("v1")
public class ServiceAController {
	
	private final AService aService;
	public ServiceAController(AService aService) {
		this.aService=aService;
	}

	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser() throws JsonProcessingException, RestClientException{
		return ResponseEntity.ok().body(aService.getAllUser());
	}
	
	@PostMapping("user/kafka")
	public ResponseEntity<String>  CreateNewUserByKafka(@RequestBody User user) throws JsonProcessingException {
		aService.SaveUserIntoServiceC(user);
		return ResponseEntity.ok().body("done save User in Service C");
	
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent(){
		return null;
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student)
	{
		return ResponseEntity.ok().body(student);
	}
	
}
