package com.nguyencongsy.models.request;

public class UserRoleViewLogin {
	private String userName;
	private String roleName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoles() {
		return roleName;
	}

}
