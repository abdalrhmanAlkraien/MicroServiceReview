package com.ServiceC.ServiceC.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ServiceC.ServiceC.entity.User;
import com.ServiceC.ServiceC.service.ServiceC;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ServiceCConsumer {
	
	private static final String TOPIC = "ReceiveFromServiceA";
	
	private final ServiceC cService;
	public ServiceCConsumer(ServiceC cService) {
		// TODO Auto-generated constructor stub
		this.cService=cService;
	}
	
	@KafkaListener(topics = TOPIC, groupId = "Service")
	public void getMessageFromServiceA(String data) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		User user=mapper.readValue(data, User.class);
		cService.createNewUser(user);
		
	}


}
