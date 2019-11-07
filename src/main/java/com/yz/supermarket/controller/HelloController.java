package com.yz.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yz.supermarket.entity.User;
import com.yz.supermarket.service.UserService;

/**
* @ClassName: HelloController  
* @Description: 测试类
* @author yangzeng
* @date 2019年11月6日  
*
 */
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
	
	@RequestMapping("/demo")
	public String demo(ModelMap mode) {
		return "/demo";
	}
}
