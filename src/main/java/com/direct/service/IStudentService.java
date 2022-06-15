package com.direct.service;

import com.direct.entity.StudentInfo;
import com.direct.util.PageModel;
import com.github.pagehelper.Page;

/**
 * 业务层接口类：定义业务方法
 * */
public interface IStudentService {
	//分页查询
//	public List<StudentInfo> queryStu();
	public Page<StudentInfo> queryStu(int current, int size);
	//调用mybatis内置的分页方法实现分页查询
	public PageModel<StudentInfo> queryStu1(int current, int size);
	
	public boolean addStu(StudentInfo sinfo);
}
