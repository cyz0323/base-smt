package com.yz.supermarket.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yz.supermarket.service.MenuService;

/**
* @ClassName: MenuController  
* @Description: 菜单管理相关内容定义
* @author yangzeng
* @date 2019年11月7日  
 */
@Controller
public class MenuController {
	private final static String PATH = "/api/menu/";
	
	@Autowired
	MenuService menuService;
	
	/**
	* @Description: 菜单页面跳转
	* @param @param mode
	* @param @return    参数  
	* @return String    返回类型  
	* @throws */
	@RequestMapping("/api/menuPage")
	public String query(ModelMap mode) {
		return PATH + "menuPage";
	}
}
