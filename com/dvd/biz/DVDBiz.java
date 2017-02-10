package com.dvd.biz;

import java.util.List;

import com.dvd.entity.DVD;

//dvd功能接口
public interface DVDBiz {
	public boolean addDVD(DVD dvd) ;//添加DVD
	public boolean delDVD(int did);//删除DVD
	public boolean modifyDVD(DVD dvd);//修改DVD
	public List<DVD> queryAllDVDs();//查询所有的DVD信息
	public List<DVD> ranking_top_5(); //查看排行榜，热门DVD,前5张最受欢迎的DVD
	public List<DVD> queryDVDByName(String dname);//根据DVD名字查询DVD
	public DVD queryDVDById(int did);//根据id查询DVD
	public int lendDVD(int did,int uid);//dvd id和用户id 租借DVD
	public int returnDVD(int rid);//归还dvd,通过记录表里面的id，记录归还时间
	public List<DVD> canLendDVD(); //查询可借DVD
	public List<DVD> hasLendedDVD();//不可以借的DVD
	
}
