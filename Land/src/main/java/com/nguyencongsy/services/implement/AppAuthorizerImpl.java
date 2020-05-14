package com.nguyencongsy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.nguyencongsy.models.Role;
import com.nguyencongsy.models.User;
import com.nguyencongsy.models.UserRole;
import com.nguyencongsy.models.request.UserRoleViewLogin;
import com.nguyencongsy.repositories.IRoleRepository;
import com.nguyencongsy.repositories.IUserRepository;
import com.nguyencongsy.repositories.IUserRoleRepository;
import com.nguyencongsy.services.AppAuthorizer;

@Service("appAuthorizer")
public class AppAuthorizerImpl implements AppAuthorizer {

    private final Logger logger = LoggerFactory.getLogger(AppAuthorizerImpl.class);
    @Autowired
	private IUserRepository userDao;
	
	@Autowired
	private IUserRoleRepository userRole_repository;
	
	@Autowired
	private IRoleRepository role_repository;
	
    @Override
    public boolean authorize(Authentication authentication, String role) {
        boolean isAllow = false;
        try {
        	
            UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) authentication;
            UserRoleViewLogin us = findByUserId(user.getName());
            if (user==null){
                return isAllow;
            }
            if(us.getRoles().contains(role))
            {
                isAllow = true;
            }
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
        return isAllow;
    }
    
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
}
