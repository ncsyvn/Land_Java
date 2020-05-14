package com.nguyencongsy.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="`user`")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	@JsonIgnore
	private String password;
	@Column(name = "u_email")
	private String u_email;
	@Column(name = "u_status")
	private Boolean u_status;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUseremail() {
		return u_email;
	}

	public void setUseremail(String useremail) {
		this.u_email = useremail;
	}

	public Boolean getUserstatus() {
		return u_status;
	}

	public void setUserstatus(Boolean u_status) {
		this.u_status = u_status;
	}

}