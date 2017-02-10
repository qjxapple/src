package com.dvd.dao;

import com.dvd.entity.User;

//用户数据层 用户的增删改查
public interface UserDao {
	public boolean saveUser(User user);//添加用户
	public boolean deleteUser(int id);//删除用户，通过id
	public boolean updateUser(User user);//更新用户
	public User queryUser(User user);//查询用户，返回值为用户类型
}
