package com.direct.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direct.dao.IClassDao;
import com.direct.entity.ClassInfo;
import com.direct.service.IClassService;

@Service("classService")
public class ClassServiceImpl implements IClassService {
	@Autowired
	private IClassDao iclaDao;

	@Override
	public List<ClassInfo> queryClass() {
		return iclaDao.selectClass();
	}
	
}
