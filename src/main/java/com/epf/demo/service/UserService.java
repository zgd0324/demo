package com.epf.demo.service;

import com.epf.demo.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

	User login(User user);

	int register(User user);

	User selectUserByName(User user);

	PageInfo<User> listUser(int pageIndex, int pageSize);
}
