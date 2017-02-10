package com.dvd.dao;

import java.util.List;

import com.dvd.entity.Record;
import com.dvd.entity.Record2;

public interface RecordDao {
	public Record queryRecordById(int rid);//通过制定id查看制定id的DVD借还记录
	public boolean saveRecord(Record record);//保存record记录
	public boolean updateRecord(Record record);//更新record
	public List<Record2> queryAllRecords();//查询所有的dvd记录
	public List<Record2> queryRecordByUname(String uname );//查询指定用户的记录
	public List<Record2> queryRecordByDname(String dname );//查询指定dvd的借还记录
	//查看用户的归还记录（已经归还，没有归还）
	public List<Record2> queryUserRecordByReturnTime(boolean flag,String uname );//查询指定dvd的借还记录
	 
}
