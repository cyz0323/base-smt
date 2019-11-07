package com.yz.supermarket.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @ClassName: DashboardController  
* @Description: 首页相关方法的定义
* @author yangzeng
* @date 2019年11月7日   */
@Controller
public class DashboardController {
	private final static String PATH = "/api/";
	
	@RequestMapping("/api/dashboard")
	public String queryPage(ModelMap model) {
		return PATH + "dashboard";
	}
}
