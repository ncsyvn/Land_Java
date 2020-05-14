package com.nguyencongsy.services;

import com.nguyencongsy.models.request.UserRoleViewLogin;

public interface IUserRoleService {
	UserRoleViewLogin findByUserId(String username);
}
