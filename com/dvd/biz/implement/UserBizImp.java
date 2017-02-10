package com.dvd.biz.implement;

import com.dvd.biz.UserBiz;
import com.dvd.dao.UserDao;
import com.dvd.dao.implement.UserDaoImp;
import com.dvd.entity.User;

//用户业务层实现类
public class UserBizImp implements UserBiz {
	private UserDao userDao = null;

	public UserBizImp() {
		userDao = new UserDaoImp();
	}

	@Override
	public User Login(User user) {
		return userDao.queryUser(user);
	}

	@Override
	public int RegistUser(User user) {
		if (userDao.queryUser(user) != null) {
			return 1;// 此用户名已经存在
		} else {
			// 说明注册用户并不存在，可以注册

			boolean res = userDao.saveUser(user);
			if (res)
				return 2;// 注册成功
			else
				return 3;//注册失败
		}
	}

}
