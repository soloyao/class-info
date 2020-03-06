package com.manage.classInfo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.UserMapper;
import com.manage.classInfo.pojo.Role;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.pojo.UserRole;
import com.manage.classInfo.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	@Autowired UserMapper userMapper;
	
	@Override
	public User login(User user) {
		return userMapper.login(user);
	}

	@Override
	public int exist(User user) {
		return userMapper.exist(user);
	}

	@Override
	public List<User> list(Map<String, String> paramMap) {
		return userMapper.list(paramMap);
	}

	@Override
	public void add(User user) {
		userMapper.add(user);//新增用户基本信息
		if (null != user.getRoles()) {//将用户对应的角色进行添加
			for (Role role : user.getRoles()) {
				UserRole userRole = new UserRole();
				userRole.setRid(role.getId());
				userRole.setUid(user.getId());
				userMapper.addRoleByUserId(userRole);
			}
		}
	}

	@Override
	public void updateUser(User user) {
		userMapper.update(user);
	}
	
	@Override
	public void update(User user) {
		//删除当前用户角色
		userMapper.deleteRoleByUserId(user.getId());
		//修改用户对应角色
		if (null != user.getRoles()) {
			for (Role role : user.getRoles()) {
				UserRole userRole = new UserRole();
				userRole.setRid(role.getId());
				userRole.setUid(user.getId());
				userMapper.addRoleByUserId(userRole);
			}
		}
		//修改用户基础信息
		userMapper.update(user);
	}
	
	@Override
	public void updateBatch(Set<String> userIds, Set<String> roleIds) {
		//删除当前用户关联角色
		for (String userId : userIds) {
			userMapper.deleteRoleByUserId(Integer.parseInt(userId));
		}
		//修改用户关联角色
		if (null != roleIds) {//为空则表示去掉用户所有角色
			for (String userId : userIds) {
				for (String roleId : roleIds) {
					UserRole userRole = new UserRole();
					userRole.setRid(Integer.parseInt(roleId));
					userRole.setUid(Integer.parseInt(userId));
					userMapper.addRoleByUserId(userRole);
				}
			}
		}
	}

	@Override
	public void delete(int id) {
		userMapper.delete(id);//删除用户
		userMapper.deleteRoleByUserId(id);//同时删除用户对应的角色
	}

	@Override
	public User get(int id) {
		return userMapper.get(id);
	}

	@Override
	public void register(User user) {
		userMapper.register(user);
		UserRole userRole = new UserRole();
		userRole.setRid(4);//写死（注册会员）
		userRole.setUid(user.getId());
		userMapper.addRoleByUserId(userRole);
	}

	@Override
	public User getByUser(User user) {
		return userMapper.getByUser(user);
	}

}
