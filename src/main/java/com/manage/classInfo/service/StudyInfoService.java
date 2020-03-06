package com.manage.classInfo.service;

import java.util.List;
import java.util.Map;

import com.manage.classInfo.pojo.StudyInfo;

public interface StudyInfoService {
	List<StudyInfo> list(Map<String, String> paramMap);
	StudyInfo get(int id);
	void add(StudyInfo studyInfo);
	void update(StudyInfo studyInfo);
	void delete(int id);
}
