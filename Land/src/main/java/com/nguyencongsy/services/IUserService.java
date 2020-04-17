package com.nguyencongsy.services;

import java.util.List;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.User;

public interface  IUserService {
	List<User> GetAllUsers();
	Page<User> GetPage(int PageSize, int PageNumber);
}
