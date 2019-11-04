package com.yz.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yz.supermarket.entity.User;
import com.yz.supermarket.service.UserService;

@RequestMapping(value="/api")
@Controller
public class HelloController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index")
	public String index(ModelMap mode) {
		User user = userService.find(1);
		mode.addAttribute("user", user);
		return "/index";
	}
}
