package com.manage.classInfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.MoneyInMapper;
import com.manage.classInfo.mapper.UserMapper;
import com.manage.classInfo.pojo.MoneyIn;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.service.MoneyInService;
import com.manage.classInfo.util.TimeUtil;

@Service
public class MoneyInServiceImpl implements MoneyInService {
	@Autowired MoneyInMapper moneyInMapper;
	@Autowired UserMapper userMapper;
	
	@Override
	public void add(MoneyIn moneyIn) {
		User user = userMapper.getByName(moneyIn.getName());
		user.setMoney(user.getMoney() + moneyIn.getCount());
		userMapper.updateMoney(user);
		moneyIn.setInDate(TimeUtil.getStringDay());
		moneyInMapper.add(moneyIn);
	}

	@Override
	public double allMoney() {
		return moneyInMapper.allMoney();
	}

}
