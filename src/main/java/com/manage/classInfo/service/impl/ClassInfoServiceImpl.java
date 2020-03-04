package com.manage.classInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.ClassInfoMapper;
import com.manage.classInfo.pojo.ClassInfo;
import com.manage.classInfo.service.ClassInfoService;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {
	@Autowired ClassInfoMapper classInfoMapper;
	
	@Override
	public List<ClassInfo> list(Map<String, String> paramMap) {
		return classInfoMapper.list(paramMap);
	}

	@Override
	public ClassInfo get(int id) {
		return classInfoMapper.get(id);
	}

	@Override
	public void add(ClassInfo classInfo) {
		classInfoMapper.add(classInfo);
	}

	@Override
	public void update(ClassInfo classInfo) {
		classInfoMapper.update(classInfo);
	}

	@Override
	public void delete(int id) {
		classInfoMapper.delete(id);
	}

}
