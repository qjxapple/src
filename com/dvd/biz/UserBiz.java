package com.dvd.biz;

import com.dvd.entity.User;

public interface UserBiz {
	//用户登录,返回的是一个用户对象（用户信息）
	public User Login(User user);
	//用户注册
	public int RegistUser(User user);
}
