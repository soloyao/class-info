package com.manage.classInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.User;
import com.manage.classInfo.pojo.UserRole;


@Mapper
public interface UserMapper {
	User login(User user);
	int exist(User user);
	List<User> list(Map<String, String> paramMap);
	void add(User user);
	void update(User user);
	void delete(int id);
	void deleteRoleByUserId(int id);
	User get(int id);
	void addRoleByUserId(UserRole userRole);
}
