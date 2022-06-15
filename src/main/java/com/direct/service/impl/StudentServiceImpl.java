package com.direct.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direct.dao.IRecordDao;
import com.direct.dao.IStudentDao;
import com.direct.entity.RecordInfo;
import com.direct.entity.StudentInfo;
import com.direct.service.IStudentService;
import com.direct.util.PageModel;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 业务层实现类：调用数据访问层的方法完成指定的业务操作
 * */
//使用注解创建业务层的实例对象并指定实例名称
@Service("stuService")
public class StudentServiceImpl implements IStudentService {
	private Logger log=LoggerFactory.getLogger(StudentServiceImpl.class);
	
	//定义dao接口属性
	@Autowired//根据类型自动注入该接口的映射器(需要在Spring容器中扫描dao接口所在的包)
	private IStudentDao istuDao;
	@Autowired
	private IRecordDao ireDao;
	
//	@Override
//	public List<StudentInfo> queryStu() {
//		log.info("查询学生信息...................");
//		return istuDao.selectStu();
//	}

	@Override
	public Page<StudentInfo> queryStu(int current, int size) {
		log.info("分页查询学生信息...................");
		//调用dao方法之前执行开启分页
		Page<StudentInfo> pg = PageHelper.startPage(current, size, true);
		istuDao.selectStu();//调用dao查询方法(普通的查询)
		return pg;
	}

	@Override
	public PageModel<StudentInfo> queryStu1(int current, int size) {
		List<StudentInfo> slist = istuDao.selectStu1(new RowBounds((current-1)*size, size));
		int count = istuDao.selectStuCount();
		
		PageModel<StudentInfo> pm=new PageModel<StudentInfo>();
		pm.setList(slist);
		pm.setSize(size);
		pm.setCurrentPage(current);
		pm.setSumCount(count);
		return pm;
	}

	@Override
	public boolean addStu(StudentInfo sinfo) {
		int count = istuDao.insertStu(sinfo);
//		int i=10/0;//模拟错误,测试事务是否生效
		int count1 = ireDao.insertRecord(new RecordInfo("添加了一条学生信息", new Date()));
		if(count>0 && count1>0) {
			log.info("添加学生信息成功.........");
			return true;
		}
		log.error("添加学生信息失败..........");
		return false;
	}
}
