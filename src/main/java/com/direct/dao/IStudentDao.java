package com.direct.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.direct.entity.StudentInfo;
/**
 * 数据持久层接口：完成数据的CRUD操作
 * */
public interface IStudentDao {
	public int insertStu(StudentInfo stu);
	
	public int updateStu(StudentInfo stu);
	
	public int deleteStuById(int sid);
	
	public StudentInfo selectStuById(int sid);
	
	public List<StudentInfo> selectStu();
	//mybatis内置分页对象
	public List<StudentInfo> selectStu1(RowBounds rb);
	public int selectStuCount();
	
}
