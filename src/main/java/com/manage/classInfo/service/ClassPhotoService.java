package com.manage.classInfo.service;

import java.util.List;
import java.util.Map;

import com.manage.classInfo.pojo.ClassPhoto;

public interface ClassPhotoService {
	List<ClassPhoto> list(Map<String, String> paramMap);
	ClassPhoto get(int id);
	void delete(int id);
	void update(ClassPhoto classPhoto);
	void add(ClassPhoto classPhoto);
}
