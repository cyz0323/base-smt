package com.yz.supermarket.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yz.supermarket.entity.Menu;
import com.yz.supermarket.mapper.MenuMapper;
import com.yz.supermarket.service.MenuService;

@Service
@Transactional(rollbackFor=Exception.class)
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuMapper menuMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> findList() {
		//返回对象
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		//查询结果
		List<Menu> lists = menuMapper.findList();
		//二级列表对象
		List<Map<String,Object>> child = null;
		for(Menu m : lists) {
			map = setMenuMap(m);
			map.put("child", new ArrayList<Map<String,Object>>());
			if(m.getMenuType() == 1) {
				//若为一级菜单
				result.add(map);
			} else {
				//若为二级菜单
				for(int i =0; i < result.size(); i++) {
					if(m.getParentId() == Integer.parseInt(String.valueOf(result.get(i).get("id")))) {
						child = (List<Map<String, Object>>) result.get(i).get("child");
						child.add(map);
						result.get(i).put("child", child);
					}
				}
			}
		}
		return result;
	}
	
	/**
	* @Description: 返回参数列表包装，数据类型如下
	* @param @param menu 菜单对象
	* @param @param map 返回菜单包装对象
	* @return void    返回类型  
	* @throws
	 */
	//返回参数列表包装称
	@SuppressWarnings("finally")
	private Map<String,Object> setMenuMap(Menu menu) {
  		Field[] fields=menu.getClass().getDeclaredFields();  
        Method method;
        String firstLetter = null;
        String getter = null;
        Map<String,Object> map = new HashMap<String,Object>();
		try {
			for(int i=0;i<fields.length;i++){  
				//序列化参数
				if("serialVersionUID".equals(fields[i].getName())) {
					continue;
				}
				//第一个首字母大写
				firstLetter = fields[i].getName().substring(0, 1).toUpperCase();  
				//方法名拼接
	            getter = "get" + firstLetter + fields[i].getName().substring(1);   
				method = menu.getClass().getMethod(getter, new Class[] {});
				Object value = method.invoke(menu, new Object[] {}); 
				if(null != value) {
					map.put(fields[i].getName(), value);
				}else {
					map.put(fields[i].getName(), null);
				}
			}  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return map;  
		}
	}
}
