package com.manage.classInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.MoneyInMapper;
import com.manage.classInfo.mapper.MoneyOutMapper;
import com.manage.classInfo.pojo.MoneyOut;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.service.MoneyOutService;
import com.manage.classInfo.util.TimeUtil;

@Service
public class MoneyOutServiceImpl implements MoneyOutService {
	@Autowired MoneyOutMapper moneyOutMapper;
	@Autowired MoneyInMapper moneyInMapper;
	
	@Override
	public List<MoneyOut> list(Map<String, String> paramMap) {
		return moneyOutMapper.list(paramMap);
	}

	@Override
	public void add(MoneyOut moneyOut, String userName) {
		//支出班费时，将每个用户的班费变成剩余班费除以用户数得出的平均班费（保留两位小数点）
		moneyOut.setName(userName);
		double allMoney = moneyInMapper.allMoney();
		double leftMoney = allMoney - moneyOut.getCount();
		moneyOut.setOutTime(TimeUtil.getStringDate());
		int userCount = moneyOutMapper.getUserCount();
		
		double aveMoney = (double)(Math.round(leftMoney / userCount * 100)) / 100;
		
		List<User> users = moneyOutMapper.listAllUser();
		for (User user : users) {
			user.setMoney(aveMoney);
			moneyOutMapper.updateMoneyByUser(user);
		}
		double allMoney1 = moneyInMapper.allMoney();
		moneyOut.setLeftMoney(allMoney1);
		moneyOutMapper.add(moneyOut);
	}
	
	@Override
	public MoneyOut get(int id) {
		return moneyOutMapper.get(id);
	}

	@Override
	public int getUserCount() {
		return moneyOutMapper.getUserCount();
	}

	@Override
	public List<User> listAllUser() {
		return moneyOutMapper.listAllUser();
	}

}
