package com.example.springbootjpa.service;

import org.springframework.data.domain.Page;

import com.example.springbootjpa.pojo.UserPojo;
import com.example.springbootjpa.pojo.UserSearchPojo;

public interface UserService {
	
	//publicPage<UserPojo> query();
	Page<UserPojo> findAll(UserSearchPojo request,int pageNo,int pageSize);

}
