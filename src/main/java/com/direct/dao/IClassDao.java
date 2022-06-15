package com.direct.dao;

import java.util.List;

import com.direct.entity.ClassInfo;
/**
 * 数据持久层接口：完成数据的CRUD操作
 * */
public interface IClassDao {
	public List<ClassInfo> selectClass();
	
}
