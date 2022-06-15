package com.ncs.training;

import java.io.Serializable;

public class Passenger implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	
}
