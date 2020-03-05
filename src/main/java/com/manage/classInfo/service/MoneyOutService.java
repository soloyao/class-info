package com.manage.classInfo.service;

import java.util.List;
import java.util.Map;

import com.manage.classInfo.pojo.MoneyOut;

public interface MoneyOutService {
	List<MoneyOut> list(Map<String, String> paramMap);
	void add(MoneyOut moneyOut);
	MoneyOut get(int id);
}
