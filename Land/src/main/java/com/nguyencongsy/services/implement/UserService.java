package com.nguyencongsy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.Role;
import com.nguyencongsy.models.User;
import com.nguyencongsy.models.UserRole;
import com.nguyencongsy.models.request.UserCreateViewModel;
import com.nguyencongsy.models.request.UserDTO;
import com.nguyencongsy.models.request.UserRoleViewLogin;
import com.nguyencongsy.models.request.UserUpdateViewModel;
import com.nguyencongsy.repositories.IRoleRepository;
import com.nguyencongsy.repositories.IUserRepository;
import com.nguyencongsy.repositories.IUserRoleRepository;
import com.nguyencongsy.services.IUserRoleService;
import com.nguyencongsy.services.IUserService;

@Service
public class UserService implements UserDetailsService, IUserRoleService, IUserService{

	@Autowired
	private IUserRepository userDao;
	
	@Autowired
	private IUserRoleRepository userRole_repository;
	
	@Autowired
	private IRoleRepository role_repository;
	

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	public User save(UserDTO user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
	@Override
	public UserRoleViewLogin findByUserId(String username) {
		UserRoleViewLogin res = new UserRoleViewLogin();
		User us = userDao.findByUsername(username);
		res.setUserName(username);
		List<UserRole> lst_user_role = new ArrayList<UserRole>();
		lst_user_role = userRole_repository.findAll();
		for (UserRole userRole : lst_user_role) {
			if(userRole.getUserID() == us.getId()) {
				int i = userRole.getRoleID();
				Role role = role_repository.getOne(i);
				res.setUserRoleName(role.getRolename());
			}
		}
		return res;
	}
	@Override
	public List<User> GetAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User SearchUserById(int userid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<User> GetPage(int PageSize, int PageNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User CreateUser(UserCreateViewModel usercreateview) {
		return null;
	}
	@Override
	public User UpdateUser(UserUpdateViewModel n) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void DeleteUser(int userid) {
		// TODO Auto-generated method stub
		
	}

}