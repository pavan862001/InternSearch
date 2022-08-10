package com.InternSearch.request;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class UserRegistrationRequest {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String role;

	private String firstName;

	private String lastName;

	private String name;

	private String email;

	private String education;

	private String college;
	
	private Float gpa;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String geteducation() {
		return education;
	}
	public void seteducation(String education) {
		this.education = education;
	}
	
	public String getcollege() {
		return college;
	}
	public void setcollege(String college) {
		this.college = college;
	}
	
	public Float getGpa() {
		return gpa;
	}
	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}
	
}