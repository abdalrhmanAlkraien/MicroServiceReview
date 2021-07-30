package com.ServiceA.ServiceA.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


public class Student {
	
	private Long id;
	private String name;
	private String address;
	private Long age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}
	
	

}
