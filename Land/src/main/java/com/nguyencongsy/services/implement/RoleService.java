package com.nguyencongsy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyencongsy.models.Role;
import com.nguyencongsy.models.request.Dropdown;
import com.nguyencongsy.repositories.IRoleRepository;
import com.nguyencongsy.services.IRoleService;
@Service
public class RoleService implements IRoleService{
	@Autowired 
	private IRoleRepository repository;
	
	public List<Dropdown> get_all_role() {
		List<Dropdown> res = new ArrayList<Dropdown>();
		
		List<Role> list_role = repository.findAll();
		for (Role role : list_role) {
			Dropdown dr = new Dropdown();
			dr.setId(role.getId());
			dr.setName(role.getRolename());
			res.add(dr);
		}
		return res;
	}
}
