package com.manage.classInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.ClassPhoto;

@Mapper
public interface ClassPhotoMapper {
	List<ClassPhoto> list(Map<String, String> paramMap);
	ClassPhoto get(int id);
	void delete(int id);
	void update(ClassPhoto classPhoto);
	void add(ClassPhoto classPhoto);
}
