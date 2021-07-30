package com.ServiceC.ServiceC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ServiceC.ServiceC.entity.User;

@Service
public class ServiceC {

	private List<User> users;
	public ServiceC() {
		users=new ArrayList<User>();		
	}
	
	public void createNewUser(User user)
	{
		users.add(user);
	}
	
	public List<User> getAllUser()
	{
		return users;
	}
}
