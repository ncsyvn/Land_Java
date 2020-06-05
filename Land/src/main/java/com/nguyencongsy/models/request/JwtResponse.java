package com.nguyencongsy.models.request;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String access_token;
	private final String userName;
	private final String roleName;
	private final int userId;
	public JwtResponse(String access_token, String userName, String roleName, int userId) {
		this.access_token = access_token;
		this.userName = userName;
		this.roleName = roleName;
		this.userId = userId;
	}

	public String getAccessToken() {
		return this.access_token;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getRoleName() {
		return this.roleName;
	}
	public int getUserId() {
		return this.userId;
	}
}