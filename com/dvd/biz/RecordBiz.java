package com.dvd.biz;

import java.util.List;

import com.dvd.entity.Record2;

public interface RecordBiz {
	public List<Record2> queryUserRecords(String uname);//查看指定用户的租赁记录,管理员功能
	public List<Record2> queryDVDRecords(String dname);//查看制定DVD的租赁记录，管理员功能
	public List<Record2> queryHasReturnedRecords(String uname);//查看指定用户的租赁记录
	public List<Record2> queryNoReturnedRecords(String uname);//查看制定用户的未归还记录
	public List<Record2> queryAllRecords(String uname);//查看制定用户的全部租赁记录 
	
}
