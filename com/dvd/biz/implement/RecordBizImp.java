 package com.dvd.biz.implement;

import java.util.List;

import com.dvd.biz.RecordBiz;
import com.dvd.dao.RecordDao;
import com.dvd.dao.implement.RecordDaoImp;
import com.dvd.entity.Record2;

public class RecordBizImp implements RecordBiz {
	private RecordDao recordDao = null;
	public RecordBizImp(){
		recordDao = new RecordDaoImp();
	}
	@Override
	public List<Record2> queryUserRecords(String uname) {
		
		return recordDao.queryRecordByUname(uname);
	}

	@Override
	public List<Record2> queryDVDRecords(String dname) {
		return recordDao.queryRecordByDname(dname);
	}

	@Override
	public List<Record2> queryHasReturnedRecords(String uname) {
		return recordDao.queryUserRecordByReturnTime(true, uname);
	}

	@Override
	public List<Record2> queryNoReturnedRecords(String uname) {
		return recordDao.queryUserRecordByReturnTime(false, uname);
	}

	@Override
	public List<Record2> queryAllRecords(String uname) {
		return recordDao.queryAllRecords();
	}

}
