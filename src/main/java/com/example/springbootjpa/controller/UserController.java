package com.example.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjpa.pojo.UserPojo;
import com.example.springbootjpa.pojo.UserSearchPojo;
import com.example.springbootjpa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findList")
	public Page<UserPojo> findList() {
		UserSearchPojo userSearch = new UserSearchPojo();
		userSearch.setEmail("@qq");
		userSearch.setName("mai");
		return userService.findAll(userSearch,0,5);
	}

}
