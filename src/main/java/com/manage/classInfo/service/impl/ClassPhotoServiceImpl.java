package com.manage.classInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.ClassPhotoMapper;
import com.manage.classInfo.pojo.ClassPhoto;
import com.manage.classInfo.service.ClassPhotoService;
import com.manage.classInfo.util.TimeUtil;

@Service
public class ClassPhotoServiceImpl implements ClassPhotoService {
	@Autowired ClassPhotoMapper classPhotoMapper;
	
	@Override
	public List<ClassPhoto> list(Map<String, String> paramMap) {
		return classPhotoMapper.list(paramMap);
	}

	@Override
	public ClassPhoto get(int id) {
		return classPhotoMapper.get(id);
	}

	@Override
	public void delete(int id) {
		classPhotoMapper.delete(id);
	}

	@Override
	public void update(ClassPhoto classPhoto) {
		classPhotoMapper.update(classPhoto);
	}

	@Override
	public void add(ClassPhoto classPhoto) {
		classPhoto.setUploadtime(TimeUtil.getStringDate());
		classPhotoMapper.add(classPhoto);
	}

}
