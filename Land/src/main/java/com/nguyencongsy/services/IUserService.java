package com.nguyencongsy.services;

import java.util.List;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.User;
import com.nguyencongsy.models.request.UserCreateViewModel;
import com.nguyencongsy.models.request.UserUpdateViewModel;

public interface IUserService {
	List<User> GetAllUsers();
	User SearchUserById(int userid);
	Page<User> GetPage(int PageSize, int PageNumber);
	User CreateUser(UserCreateViewModel n);
	User UpdateUser(UserUpdateViewModel n);
	void DeleteUser(int userid);
}
