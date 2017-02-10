package com.dvd.biz.implement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dvd.biz.DVDBiz;
import com.dvd.dao.DVDDao;
import com.dvd.dao.RecordDao;
import com.dvd.dao.implement.DVDDaoImp;
import com.dvd.dao.implement.RecordDaoImp;
import com.dvd.entity.DVD;
import com.dvd.entity.Record;

public class DVDBizImp implements DVDBiz {
	private DVDDao dvdDao = null;
	private RecordDao recordDao = null;

	public DVDBizImp() {
		dvdDao = new DVDDaoImp();
		recordDao = new RecordDaoImp();
	}

	@Override
	public boolean addDVD(DVD dvd) {
		return dvdDao.saveDVD(dvd);
	}

	@Override
	public boolean delDVD(int did) {
		return dvdDao.deleteDVD(did);
	}

	@Override
	public boolean modifyDVD(DVD dvd) {
		return dvdDao.updateDVD(dvd);
	}

	@Override
	public List<DVD> queryAllDVDs() {
		return dvdDao.queryDVDs();
	}

	@Override
	public List<DVD> ranking_top_5() {
		return dvdDao.querySortDVDByLimit(0, 5);
	}

	@Override
	public List<DVD> queryDVDByName(String dname) {
		return dvdDao.queryDVDByName(dname);
	}

	@Override
	public DVD queryDVDById(int did) {
		return dvdDao.queryDVDByID(did);
	}
	//借DVD
	@Override
	public int lendDVD(int did, int uid) {
		DVD dvd = this.queryDVDById(did);
		if (dvd == null) {
			return 0;// 没有找到要借的DVD
		} else {
			if (dvd.getStatus() == 0) {
				return 1;// 代表不可借，已经被借出了
			} else {
				dvd.setStatus(0);// 更新dvd借的状态
				dvd.setDcount(dvd.getDcount() + 1);// DVD借出数量+1
				boolean flag1 = dvdDao.updateDVD(dvd); //更新DVD信息
				Record record = new Record(uid, dvd.getId(),
						new SimpleDateFormat("yyyy-YY-dd").format(new Date()),
						null);//添加记录
				boolean flag2 = recordDao.saveRecord(record);
				if(flag1 && flag2) {
					return 2;//借出成功
				}else
					return 3;//借出失败
			}
		}

	}
	//归还DVD
	@Override
	public int returnDVD(int rid) {
		 //1、查看是否借过dvd
		Record record = recordDao.queryRecordById(rid);
		if(record == null) {
			return 1;//输入不正确，没有相应的借阅信息
		}else if(record.getReturnTime() != null	){
			return 2;//代表dvd已经归还了
		}else {
			record.setReturnTime(new SimpleDateFormat("yyyy-YY-dd").format(new Date()));//记录归还时间
			boolean flag1 = recordDao.updateRecord(record);//更新记录表,返回boolean类型的值
			//更新dvd借阅信息
			DVD dvd = dvdDao.queryDVDByID(record.getDid());//找到对应的DVD，返回的就是DVD对象
			dvd.setStatus(1);//修改dvd可借状态
			boolean flag2 = dvdDao.updateDVD(dvd);//更新dvd信息
			if(flag1 && flag2) {
				return 3;//归还成功
			}else
				return 4;//归还失败
			
		}
	}
	//查看能够借阅的DVD
	@Override
	public List<DVD> canLendDVD() {
		return dvdDao.queryDVDByStatus(1);
	}
	//查看已经借阅的DVD
	@Override
	public List<DVD> hasLendedDVD() {
		return dvdDao.queryDVDByStatus(0);
	}

}
