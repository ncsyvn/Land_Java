package com.nguyencongsy.models.request;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String access_token;
	private final String userName;
	private final String roleName;
	public JwtResponse(String access_token, String userName, String roleName) {
		this.access_token = access_token;
		this.userName = userName;
		this.roleName = roleName;
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
}