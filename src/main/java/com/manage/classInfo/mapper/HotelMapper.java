package com.manage.classInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.Hotel;


@Mapper
public interface HotelMapper {
	List<Hotel> list(Map<String, String> paramMap);
	void add(Hotel hotel);
	void delete(int id);
	void update(Hotel hotel);
	Hotel get(int id);
}
