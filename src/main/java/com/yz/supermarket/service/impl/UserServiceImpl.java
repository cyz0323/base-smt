package com.yz.supermarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yz.supermarket.entity.User;
import com.yz.supermarket.mapper.UserMapper;
import com.yz.supermarket.service.UserService;

@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public User find(int id) {
		return userMapper.find(id);
	}
}
