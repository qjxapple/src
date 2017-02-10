package com.dvd.dao.implement;

import java.util.ArrayList;
import java.util.List;

import com.dvd.dao.RecordDao;
import com.dvd.entity.DVD;
import com.dvd.entity.Record;
import com.dvd.entity.Record2;

public class RecordDaoImp extends BaseDao implements RecordDao {
	// 通过指定id查询借阅信息
	@Override
	public Record queryRecordById(int rid) {
		String sql = "select id,uid,did,lendTime,returnTime from Records where id=?";
		List<Record> rList = null;
		List<Object> params = new ArrayList<Object>();
		try {
			rList = this.operateQuery(sql, params, Record.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rList.size() > 0)
			return rList.get(0);

		return null;
	}

	// 保存借阅信息
	@Override
	public boolean saveRecord(Record record) {
		String sql = "insert into Records (uid,did,lendTime,returnTime) values (?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(record.getDid());
		params.add(record.getUid());
		params.add(record.getLendTime());
		params.add(record.getReturnTime());
		return this.operateUpdate(sql, params);
	}

	// 更新信息
	@Override
	public boolean updateRecord(Record record) {
		String sql = "Update Records set uid=?,did=?,lendTime=?,returnTime=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(record.getDid());
		params.add(record.getUid());
		params.add(record.getLendTime());
		params.add(record.getReturnTime());
		params.add(record.getId());
		return this.operateUpdate(sql, params);
	}

	@Override
	public List<Record2> queryAllRecords() {
		String sql = "select r.id,d.id as did,u.uname,d.dname,r.lendTime,r.returnTime from "
				+ "users u,dvds ,records r where u.id=r.uid and d.id = r.did";
		List<Record2> r2List = null;
		try {
			r2List = this.operateQuery(sql, null, Record2.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r2List;
	}

	@Override
	public List<Record2> queryRecordByUname(String uname) {
		String sql = "select r.id,d.id as did,u.uname,d.dname,r.lendTime,r.returnTime from "
				+ "users u,dvds ,records r where u.id=r.uid and d.id = r.did and uname=?";
		List<Record2> r2List = null;
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		try {
			r2List = this.operateQuery(sql, params, Record2.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r2List;
	}

	@Override
	public List<Record2> queryRecordByDname(String dname) {
		String sql = "select r.id,d.id as did,u.uname,d.dname,r.lendTime,r.returnTime from "
				+ "users u,dvds ,records r where u.id=r.uid and d.id = r.did and dname=?";
		List<Record2> r2List = null;
		List<Object> params = new ArrayList<Object>();
		params.add(dname);
		try {
			r2List = this.operateQuery(sql, params, Record2.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r2List;
	}
	//查看用户的借还记录，包括用户的已归还记录，或者未归还记录
	@Override
	public List<Record2> queryUserRecordByReturnTime(boolean flag, String uname) {
		String sql = null;
		if(flag) {
			sql = "select r.id,d.id as did,u.uname,d.dname,r.lendTime,r.returnTime from "
					+ "users u,dvds ,records r where u.id=r.uid and d.id = r.did and returnTime is not null "
					+ "uname=? ";
		}else{
			sql = "select r.id,d.id as did,u.uname,d.dname,r.lendTime,r.returnTime from "
					+ "users u,dvds ,records r where u.id=r.uid and d.id = r.did and returnTime is null "
					+ "uname=? ";
		}
		List<Object> params = new ArrayList<Object>();
		List<Record2> r2List = null;
		params.add(uname);
		try {
			r2List = this.operateQuery(sql, params, Record2.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r2List;
	}

}
