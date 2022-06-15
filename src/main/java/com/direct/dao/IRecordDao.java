package com.direct.dao;

import com.direct.entity.RecordInfo;
/**
 * 数据持久层接口：完成数据的CRUD操作
 * */
public interface IRecordDao {
	public int insertRecord(RecordInfo rinfo);
}
