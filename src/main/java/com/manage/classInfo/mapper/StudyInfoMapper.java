package com.manage.classInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.StudyInfo;

@Mapper
public interface StudyInfoMapper {
	List<StudyInfo> list(Map<String, String> paramMap);
	StudyInfo get(int id);
	void add(StudyInfo studyInfo);
	void update(StudyInfo studyInfo);
	void delete(int id);
}
