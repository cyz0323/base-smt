package com.yz.supermarket.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yz.supermarket.service.MenuService;
import com.yz.supermarket.service.UserService;

/**
* @ClassName: MainController  
* @Description: 主页跳转
* @author yangzeng
* @date 2019年11月6日  
 */
@Controller
@RequestMapping(value="/app")
public class MainController {
	
	@Autowired
	UserService userService;
	@Autowired
	MenuService menuService;
	
	/**
	* @Description: 首页请求
	* @param @param mode
	* @param @return    参数  
	* @return String    返回类型  
	* @throws
	 */
	@RequestMapping("/index")
	public String index(ModelMap mode) {
		mode.addAttribute("user", userService.find(1));
		mode.addAttribute("menu", menuService.findList());
		return "/index";
	}
	
}
