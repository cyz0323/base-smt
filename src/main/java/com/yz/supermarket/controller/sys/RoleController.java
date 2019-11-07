package com.yz.supermarket.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @ClassName: RoleController  
* @Description: 系统管理角色控制相关管理
* @author yangzeng
* @date 2019年11月7日  
 */
@Controller
public class RoleController {
	private final static String PATH = "/api/role/";
	
	/**
	* @Description: 角色页面跳转
	* @param @param mode
	* @param @return    参数  
	* @return String    返回类型  
	* @throws	 */
	@RequestMapping("/api/rolePage")
	public String queryPage(ModelMap mode) {
		return PATH + "rolePage";
	}
}
