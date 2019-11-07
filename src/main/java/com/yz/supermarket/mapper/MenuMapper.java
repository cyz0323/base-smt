package com.yz.supermarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yz.supermarket.entity.Menu;

@Mapper
public interface MenuMapper {
	List<Menu> findList();
}
