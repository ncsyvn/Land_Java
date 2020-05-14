package com.nguyencongsy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.User;
import com.nguyencongsy.models.request.Dropdown;
import com.nguyencongsy.models.request.UserCreateViewModel;
import com.nguyencongsy.models.request.UserUpdateViewModel;
import com.nguyencongsy.services.implement.RoleService;
import com.nguyencongsy.services.implement.UserService;
import com.nguyencongsy.utils.SendMailService;

@RestController
@CrossOrigin
@PreAuthorize("@appAuthorizer.authorize(authentication, 'admin')")
@RequestMapping("/api/Users")
public class UserController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private SendMailService sendMailService;
	String username = "";
	String password = "";
	@GetMapping({ "/get_all_role" })
	public @ResponseBody Response<List<Dropdown>> Get_role() {
		Response<List<Dropdown>> res = new Response<List<Dropdown>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = roleService.get_all_role();
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = e.getMessage();
			res.Data = null;
			System.out.print(e.getMessage());

		}
		return res;
	}
	
	@GetMapping({"/get_all"})
	public @ResponseBody Response<Page<User>> GetAll(@RequestParam("pagesize") int pagesize, 
			@RequestParam("pagenumber") int pagenumber) {
		Response<Page<User>> res = new Response<Page<User>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data =userService.GetPage(pagesize, pagenumber); ;
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = e.getMessage();
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	@GetMapping({"/get_by_id"})
	public @ResponseBody Response<User> Get(@RequestParam("userid") int userid) {
		Response<User> res = new Response<User>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data =userService.SearchUserById(userid);
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = e.getMessage();
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	@GetMapping({"/create"})
	public @ResponseBody Response<User> Create(@RequestBody UserCreateViewModel usercreateview) {
		Response<User> res = new Response<User>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = userService.CreateUser(usercreateview);;
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = e.getMessage();
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	@GetMapping({"/update"})
	public @ResponseBody Response<User> Update(@RequestBody UserUpdateViewModel userupdateview) {
		Response<User> res = new Response<User>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = userService.UpdateUser(userupdateview);
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = e.getMessage();
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	@GetMapping({"/send_mail"})
	public @ResponseBody Response<String> Send_Mail() throws Exception {
		Response<String> res = new Response<String>();
		try {
			String text_send = "";
			text_send = sendMailService.Get_TemPlate_SendMail(true,false,username, password);
			sendMailService.sendEmail(text_send, "duongduccpcntt@gmail.com", "created user");
			res.Code = 200;
			res.Message = "Success";
			res.Data = "ok";
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = e.getMessage();
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	@GetMapping({"/delete"})
	public @ResponseBody Response<String> Delete(@RequestParam("userid") int userid) {
		Response<String> res = new Response<String>();
		try {
			userService.DeleteUser(userid);
			res.Code = 200;
			res.Message = "Success";
			res.Data = "ok!";
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = e.getMessage();
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
}
