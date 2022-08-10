package com.epf.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epf.demo.dao.UserDao;
import com.epf.demo.entity.User;
import com.epf.demo.service.UserService;
import com.github.pagehelper.PageInfo;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public int register(User user) {
		return userDao.register(user);
	}

	@Override
	public User selectUserByName(User user) {
		return userDao.selectUserByName(user);
	}

	@Override
	public PageInfo<User> listUser(int pageIndex, int pageSize) {
		return userDao.listUser();
	}

}
