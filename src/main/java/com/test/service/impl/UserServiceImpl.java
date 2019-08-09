package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.test.mapper.UserMapper;
import com.test.pojo.User;
import com.test.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)//事务回滚
	public List<User> ShowAll(int pageNum , int pageSize) {
		
		// 开始分页
        PageHelper.startPage(pageNum, pageSize);
        
		List<User> userlist = userMapper.SelectAll();
		return userlist;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)//事务回滚
	public void SaveUser(User user) {
		userMapper.Insert(user);
	
		
	}

}
