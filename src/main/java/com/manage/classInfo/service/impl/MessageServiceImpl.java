package com.manage.classInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.MessageMapper;
import com.manage.classInfo.pojo.Message;
import com.manage.classInfo.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired MessageMapper messageMapper;
	
	@Override
	public List<Message> list(Map<String, String> paramMap) {
		return messageMapper.list(paramMap);
	}

	@Override
	public Message get(int id) {
		return messageMapper.get(id);
	}

	@Override
	public void delete(int id) {
		messageMapper.delete(id);
	}

	@Override
	public void add(Message message) {
		messageMapper.add(message);
	}

}
