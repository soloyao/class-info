package com.manage.classInfo.service;

import java.util.List;
import java.util.Map;

import com.manage.classInfo.pojo.MoneyOut;
import com.manage.classInfo.pojo.User;

public interface MoneyOutService {
	List<MoneyOut> list(Map<String, String> paramMap);
	void add(MoneyOut moneyOut, String userName);
	void addUser(MoneyOut moneyOut, String userName);
	MoneyOut get(int id);
	int getUserCount();
	List<User> listAllUser();
}
