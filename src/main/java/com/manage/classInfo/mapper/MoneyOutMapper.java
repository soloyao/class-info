package com.manage.classInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.MoneyOut;

@Mapper
public interface MoneyOutMapper {
	List<MoneyOut> list(Map<String, String> paramMap);
	void add(MoneyOut moneyOut);
	MoneyOut get(int id);
}
