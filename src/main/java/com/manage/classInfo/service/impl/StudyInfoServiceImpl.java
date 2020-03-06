package com.manage.classInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.StudyInfoMapper;
import com.manage.classInfo.pojo.StudyInfo;
import com.manage.classInfo.service.StudyInfoService;

@Service
public class StudyInfoServiceImpl implements StudyInfoService {
	@Autowired StudyInfoMapper studyInfoMapper;
	
	@Override
	public List<StudyInfo> list(Map<String, String> paramMap) {
		return studyInfoMapper.list(paramMap);
	}

	@Override
	public StudyInfo get(int id) {
		return studyInfoMapper.get(id);
	}

	@Override
	public void add(StudyInfo studyInfo) {
		studyInfoMapper.add(studyInfo);
	}

	@Override
	public void update(StudyInfo studyInfo) {
		studyInfoMapper.update(studyInfo);
	}

	@Override
	public void delete(int id) {
		studyInfoMapper.delete(id);
	}

}
