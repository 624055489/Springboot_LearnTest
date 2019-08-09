package com.test.mapper;

import java.util.List;


import com.test.pojo.User;

public interface UserMapper {
	
	List<User> SelectAll(); 
	
	int Insert(User user);
}
