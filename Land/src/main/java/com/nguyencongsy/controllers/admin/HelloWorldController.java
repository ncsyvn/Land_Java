package com.nguyencongsy.controllers.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping({ "/hello" })
	@PreAuthorize("@appAuthorizer.authorize(authentication, 'admin')")
	public String firstPage() {
		return "Hello World";
	}

}