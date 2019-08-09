package com.test.service;

import java.util.List;

import com.test.pojo.User;

public interface UserService {
	public List<User> ShowAll(int pageNum , int pageSize);
	
	public  void SaveUser(User user);
}
