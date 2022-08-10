package com.InternSearch.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String college;

	private String email;

	private String education;

	private Float gpa;

	private String username;

	@OneToMany
	@Transient
	private List<Job> appliedJobs;


	@Transient
	private String applicationStatus;


	public Candidate(){
		
	}
	
	public Candidate(String name, String college, String email, String education, Float gpa,
			String username) {

		this.name = name;
		this.college = college;
		this.email = email;
		this.education = education;
		this.gpa = gpa;
		this.username = username;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Job> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(List<Job> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}
	
	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getcollege() {
		return college;
	}

	public void setcollege(String college) {
		this.college = college;
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

	public Float getGpa() {
		return gpa;
	}

	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}