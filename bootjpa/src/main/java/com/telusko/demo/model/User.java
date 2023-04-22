package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
	private String emailId;
	private String password;
	private String reEnteredPassword;
	private String role;

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ",  password=" + password + "]";
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReEnteredPassword() {
		return reEnteredPassword;
	}

	public void setReEnteredPassword(String reEnteredPassword) {
		this.reEnteredPassword = reEnteredPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
