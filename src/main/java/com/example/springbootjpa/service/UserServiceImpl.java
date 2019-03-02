package com.example.springbootjpa.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Range;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.springbootjpa.dao.UserDao;
import com.example.springbootjpa.pojo.UserPojo;
import com.example.springbootjpa.pojo.UserSearchPojo;
import com.example.springbootjpa.utils.StringUtil;
import com.github.wenhao.jpa.Sorts;
import com.github.wenhao.jpa.Specifications;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 条件查询与分页实现
	 */
	public Page<UserPojo> findAll(UserSearchPojo request,int pageNo,int pageSize) {
		Specification<UserPojo> specification = Specifications.<UserPojo>and()
	            .eq(StringUtil.isNotBlank(request.getName()), "name", request.getName())	           
	            .like("email", "%"+request.getEmail()+"%")
	            .build();
		            
		Sort sort = Sorts.builder()
		        .desc(StringUtil.isNotBlank(request.getName()), "name")
		        .asc("id")
		        .build();
		            
		    return userDao.findAll(specification, new PageRequest(pageNo, pageSize, sort));
	}

}
