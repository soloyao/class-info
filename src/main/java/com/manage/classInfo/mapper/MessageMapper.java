package com.manage.classInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.Message;

@Mapper
public interface MessageMapper {
	List<Message> list(Map<String, String> paramMap);
	Message get(int id);
	void delete(int id);
	void add(Message message);
}
