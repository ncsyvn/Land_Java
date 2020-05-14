package com.nguyencongsy.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ur_id;
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "role_id")
	private int role_id;

	public int getUserID() {
		return user_id;
	}

	public void setRolename(int user_id) {
		this.user_id = user_id;
	}
	
	public int getRoleID() {
		return role_id;
	}

	public void setRoleID(int role_id) {
		this.role_id = role_id;
	}

}
