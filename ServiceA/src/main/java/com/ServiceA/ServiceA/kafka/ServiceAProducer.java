package com.ServiceA.ServiceA.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.ServiceA.ServiceA.Entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ServiceAProducer {
    private KafkaTemplate<String, String> kafkaTemplate;
    
	public ServiceAProducer(KafkaTemplate<String, String> kafkaTemplate) {
		// TODO Auto-generated constructor stub
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendToServiceC(User user) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		kafkaTemplate.send("ReceiveFromServiceA",mapper.writeValueAsString(user));
		
	}

}
