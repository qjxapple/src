package com.dvd.dao.implement;

import java.util.ArrayList;
import java.util.List;

import com.dvd.dao.DVDDao;
import com.dvd.entity.DVD;

public class DVDDaoImp extends BaseDao implements DVDDao {
	// 添加DVD
	@Override
	public boolean saveDVD(DVD dvd) {
		String sql = "insert into dvds(dname,dcount,status) values (?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(dvd.getDname());
		params.add(dvd.getDcount());
		params.add(dvd.getStatus());
		return this.operateUpdate(sql, params);
	}

	// 更新dvd信息
	@Override
	public boolean updateDVD(DVD dvd) {
		String sql = "update users set dname=?,dcount=?,status=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dvd.getDname());
		params.add(dvd.getDcount());
		params.add(dvd.getStatus());
		params.add(dvd.getId());
		return this.operateUpdate(sql, params);
	}

	// 删除dvd
	@Override
	public boolean deleteDVD(int did) {
		String sql = "delete from dvds where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(did); // 只有一个id
		return this.operateUpdate(sql, params);

	}

	@Override
	public List<DVD> queryDVDs() {
		String sql = "select id,dcount,status from dvds ";
		List<DVD> dList = null;
		try {
			dList = this.operateQuery(sql, null, DVD.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

	@Override
	public List<DVD> queryDVDByName(String dname) {
		String sql = "select id,dcount,status from dvds where dname=?";
		List<DVD> dList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(dname);
		try {
			dList = this.operateQuery(sql, params, DVD.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

	@Override
	/**
	 * 查看排序的视图，热门dvd,传入参数为  从第几到第几的排序
	 */
	public List<DVD> querySortDVDByLimit(int index, int number) {
		String sql = "select id,dname,dcount,status from dvds order by dcount desc limit"
				+ index + "," + number;
		List<DVD> dList = null;
		try {
			dList = this.operateQuery(sql, null, DVD.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

	@Override
	// 通过指定id查询dvd
	public DVD queryDVDByID(int did) {

		String sql = "select id,dcount,status from dvds where id=?";
		List<DVD> dList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(did);
		try {
			dList = this.operateQuery(sql, params, DVD.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dList.size() > 0)
			return dList.get(0);
		return null;
	}

	@Override
	public List<DVD> queryDVDByStatus(int status) {
		String sql = "select id,dcount,status from dvds where sttus=?";
		List<DVD> dList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(status);
		try {
			dList = this.operateQuery(sql, params, DVD.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dList.size() > 0)
			return dList;
		return null;
	}

}
