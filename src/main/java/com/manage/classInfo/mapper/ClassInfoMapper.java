package com.manage.classInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.ClassInfo;

@Mapper
public interface ClassInfoMapper {
	List<ClassInfo> list(Map<String, String> paramMap);
	ClassInfo get(int id);
	void add(ClassInfo classInfo);
	void update(ClassInfo classInfo);
	void delete(int id);
}
