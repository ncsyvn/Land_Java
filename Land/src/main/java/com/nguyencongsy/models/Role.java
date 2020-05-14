package com.nguyencongsy.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int r_id;
	@Column(name = "r_name")
	private String r_name;
	@Column(name = "r_description")
	private String r_description;
	@Column(name = "r_status")
	private Boolean r_status;
	
	public int getId() {
		return r_id;
	}
	public String getRolename() {
		return r_name;
	}

	public void setRolename(String r_name) {
		this.r_name = r_name;
	}
	
	public String getRoleDescription() {
		return r_description;
	}

	public void setRoleDescription(String r_description) {
		this.r_description = r_description;
	}

	public Boolean getRolestatus() {
		return r_status;
	}

	public void setRolestatus(Boolean u_status) {
		this.r_status = u_status;
	}

}
