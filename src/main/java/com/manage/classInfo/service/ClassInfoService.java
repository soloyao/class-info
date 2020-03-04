package com.manage.classInfo.service;

import java.util.List;
import java.util.Map;

import com.manage.classInfo.pojo.ClassInfo;

public interface ClassInfoService {
	List<ClassInfo> list(Map<String, String> paramMap);
	ClassInfo get(int id);
	void add(ClassInfo classInfo);
	void update(ClassInfo classInfo);
	void delete(int id);
}
