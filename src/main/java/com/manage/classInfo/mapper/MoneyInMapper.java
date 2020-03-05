package com.manage.classInfo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.MoneyIn;

@Mapper
public interface MoneyInMapper {
	void add(MoneyIn moneyIn);
	double allMoney();
}
