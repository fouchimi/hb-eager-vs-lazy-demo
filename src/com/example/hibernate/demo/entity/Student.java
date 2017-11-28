package com.example.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	public Student() {
		
	}
	
	public Student(String firstNanme, String lastName, String email) {
		this.firstNanme = firstNanme;
		this.lastName = lastName;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	@Column(name="first_name")
	private String firstNanme;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	public String getFirstNanme() {
		return firstNanme;
	}

	public void setFirstNanme(String firstNanme) {
		this.firstNanme = firstNanme;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstNanme=" + firstNanme + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
