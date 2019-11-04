package com.yz.supermarket.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yz.supermarket.entity.User;

@Mapper
public interface UserMapper {
    
    public User find(int id);
}
