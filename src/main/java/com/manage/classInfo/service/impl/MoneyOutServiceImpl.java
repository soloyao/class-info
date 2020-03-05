package com.manage.classInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.MoneyOutMapper;
import com.manage.classInfo.pojo.MoneyOut;
import com.manage.classInfo.service.MoneyOutService;

@Service
public class MoneyOutServiceImpl implements MoneyOutService {
	@Autowired MoneyOutMapper moneyOutMapper;
	
	@Override
	public List<MoneyOut> list(Map<String, String> paramMap) {
		return moneyOutMapper.list(paramMap);
	}

	@Override
	public void add(MoneyOut moneyOut) {
		moneyOutMapper.add(moneyOut);
	}

	@Override
	public MoneyOut get(int id) {
		return moneyOutMapper.get(id);
	}

}
