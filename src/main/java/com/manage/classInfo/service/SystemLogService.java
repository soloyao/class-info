package com.manage.classInfo.service;

import java.util.List;
import java.util.Map;

import com.manage.classInfo.pojo.SystemLog;



public interface SystemLogService {
	void save(SystemLog systemLog);
	List<SystemLog> list(Map<String, String> paramMap);
}
