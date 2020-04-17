package com.nguyencongsy.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AspNetUsers")
public class User implements Serializable {
	@Id
	@Column(name = "Id")
	private String id;
	@Column(name = "Username")
	private String Username;
	@Column(name = "PasswordHash")
	private String Password;
	@Column(name = "PhoneNumber")
	private String PhoneNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	
}
