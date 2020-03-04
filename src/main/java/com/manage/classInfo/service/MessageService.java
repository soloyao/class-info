package com.manage.classInfo.service;

import java.util.List;
import java.util.Map;

import com.manage.classInfo.pojo.Message;

public interface MessageService {
	List<Message> list(Map<String, String> paramMap);
	Message get(int id);
	void delete(int id);
	void add(Message message);
}
