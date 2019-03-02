package com.example.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjpa.dao.UserDao;
import com.example.springbootjpa.pojo.UserPojo;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping("/queryByName")
	public UserPojo queryByName() {
		UserPojo user = userDao.findByName("mai");
		System.out.println("查询结果"+user.getEmail());
		if(user!=null) {
			System.out.println(user.getEmail());
		}
		return user;
	}
	
	@RequestMapping("/add")
	public UserPojo add() {
		UserPojo user = new UserPojo();
		user.setId(1L);
		user.setEmail("dfsfsd@qq.com");
		user.setName("mai");
		userDao.save(user);
		return user;
	}
	
	@RequestMapping("/queryTwo")
	public List<UserPojo> queryTwo() {
		long id = 1L;
		List<UserPojo> user = userDao.findTwoName("mai", id);
		System.out.println("查询结果"+user.get(0).getEmail());
		if(user!=null) {
			System.out.println(user.get(0).getEmail());
		}
		return user;
	}

}
