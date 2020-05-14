package com.nguyencongsy.models.request;

public class UserCreateViewModel {
	private String username;
	private String password;
	private String u_email;
	private Boolean u_status;
	
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
