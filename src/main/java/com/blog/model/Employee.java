package com.blog.model;

import javax.validation.constraints.Size;

//import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;

public class Employee {
	
	int id;
	@NotEmpty(message="Name is required")
	String name;
	@NotEmpty(message="age is required")
	@Size(max=7,min=4)
	Integer age;
	@Email(message="Invalid email")
	String email;
	@NotEmpty(message="password is required")
	String password;

	public Employee() {

	}

	public Employee(int id, String name, Integer age, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
