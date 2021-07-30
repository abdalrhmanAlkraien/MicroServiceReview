package com.ServiceA.ServiceA.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ServiceA.ServiceA.Entity.Student;
import com.ServiceA.ServiceA.Entity.User;
import com.ServiceA.ServiceA.kafka.ServiceAProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AService {

	private static RestTemplate restTemplate;
	private final ServiceAProducer aProducer;
	
	private List<Student> students;
	private List<User> user;

	public AService(RestTemplate restTemplate,ServiceAProducer aProducer) {
		this.restTemplate = restTemplate;
		this.students = new ArrayList<>();
		this.user = new ArrayList<User>();
		this.aProducer=aProducer;
	}

	// Get AllUser From ServiceB
	public List<User> getAllUser() throws JsonProcessingException, RestClientException {
		String url = "http://localhost:8082/v1/user";
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		List<String> list=mapper.readValue(restTemplate.exchange(url, HttpMethod.GET,entity, String.class).getBody(), List.class);
		int size=list.size();
		for(int i=0;i<size;i++)
			user.add(mapper.convertValue(list.get(i), User.class));

		return user;
	}

	public void SaveUserIntoServiceC(User user) throws JsonProcessingException
	{
		aProducer.sendToServiceC(user);
	}
	public List<Student> getAllStudents() {
		return this.students;
	}

	public Student createStudent(Student student) {
		students.add(student);
		return student;
	}
}
