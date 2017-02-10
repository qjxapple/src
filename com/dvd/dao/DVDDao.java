package com.dvd.dao;


import java.util.List;

import com.dvd.entity.DVD;

public interface DVDDao {
	public boolean saveDVD(DVD dvd);// 添加DVD
	public boolean updateDVD(DVD dvd);//更新DVD
	public boolean deleteDVD(int did);//删除制定的DVD
	public List<DVD> queryDVDs();//查询所有的DVD
	public List<DVD> queryDVDByName(String dname);//查找制定名字的DVD
	public List<DVD> querySortDVDByLimit(int index,int number);//查找制定起始位的制定数量的DVD
	public DVD queryDVDByID(int did);//根据DVD编号查询DVD
	public List<DVD> queryDVDByStatus(int status);//根据DVD状态查询DVD
}
