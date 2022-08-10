package com.epf.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import com.epf.demo.entity.User;
import com.github.pagehelper.PageInfo;

@Mapper
public interface UserDao {
	
	User login(User user);

	int register(User user);

	User selectUserByName(User user);

	PageInfo<User> listUser();

}
