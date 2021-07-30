package com.ServiceB.ServiceB.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ServiceB.ServiceB.Entity.User;

@Service
public class BService {
	
	private List<User> users;
	public BService(){
		this.users=new ArrayList<User>();
	}
	
	public List<User> getAllUser() {
		return users;
	}
	
	public User createNewUser(User user) {
		users.add(user);
		return user;
	}
}
