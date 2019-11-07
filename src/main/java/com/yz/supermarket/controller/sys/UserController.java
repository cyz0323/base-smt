package com.yz.supermarket.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @ClassName: UserController  
* @Description: 用户管理页面跳转
* @author yangzeng
* @date 2019年11月7日   */
@Controller
public class UserController {
	private final static String PATH = "/api/user/";
	
	/**
	* @Description: 用户管理页面的跳转
	* @param @param model
	* @param @return    参数  
	* @return String    返回类型  
	* @throws */
	@RequestMapping("/api/userPage")
	public String queryPage(ModelMap model) {
		return PATH + "userPage";
	}
}
