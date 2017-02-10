package com.dvd.dao.implement;

import java.util.ArrayList;
import java.util.List;

import com.dvd.dao.UserDao;
import com.dvd.entity.User;

public class UserDaoImp extends BaseDao implements UserDao {
	// 保存用户信息到数据库
	@Override
	public boolean saveUser(User user) {
		String sql = "insert into users (uname,upass,kind) values (?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());

		return this.operateUpdate(sql, params);
	}

	// 删除用户
	@Override
	public boolean deleteUser(int id) {
		String sql = "delete from users where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id); // 只有一个id
		return this.operateUpdate(sql, params);
	}

	// 修改用户信息
	@Override
	public boolean updateUser(User user) {
		String sql = "update users set uname=?,upass=?,kind=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());
		params.add(user.getId());
		return this.operateUpdate(sql, params);
	}

	// 查询用户
	@Override
	public User queryUser(User user) {
		String sql = "select id, uname,upass,kind from users where uname=? and upass=? and kind=?";
		List<Object> params = new ArrayList<Object>();
		List<User> uList = null;
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());
		try {
			uList = this.operateQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (uList.size() > 0) {
			return uList.get(0);
		}
		return null;
	}

}
