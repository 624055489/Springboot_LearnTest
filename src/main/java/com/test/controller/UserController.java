package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.pojo.User;
import com.test.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("User")
	public Map<String, Object>  ShowAll(Integer pageNum){
		
		if (pageNum==null) {
			pageNum=1;
			}
		int pageSize =5;
		Map<String, Object> modelmap = new HashMap<String, Object>();
		modelmap.put("userlist", userService.ShowAll(pageNum, pageSize));
		return modelmap;
	}
	
	@RequestMapping("save")
	public int SaveUser() {
		User user= new User();
		user.setId(99);
		user.setName("test");
		user.setNum("110");
		 userService.SaveUser(user);
		 
		 return 1;
	}

}
