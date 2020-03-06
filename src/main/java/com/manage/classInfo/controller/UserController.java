package com.manage.classInfo.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.classInfo.pojo.Role;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.service.RoleService;
import com.manage.classInfo.service.UserService;

/**
 * @ClassName:UserController
 * @Description:用户管理
 * @date:2020年3月6日 上午10:46:26
 */
@RestController
public class UserController {
	@Autowired UserService userService;
	@Autowired RoleService roleService;
	
	/**
	 * 获取当前登录用户的个人信息
	 * @param session
	 * @return
	 */
	@GetMapping("/currentUser")
	public String currentUser(HttpSession session) {
		User currentUser = (User) session.getAttribute("user");
		User user = userService.getByUser(currentUser);
		JSONObject json = new JSONObject();
		json.put("user", user);
		return json.toJSONString();
	}
	
	/**
	 * 修改用户个人信息
	 * @param user
	 * @param session
	 * @return
	 */
	@PutMapping("/currentUser")
	public String updateUser(@RequestBody User user, HttpSession session) {
		JSONObject json = new JSONObject();
		userService.updateUser(user);
		session.setAttribute("user", user);
		json.put("code", 0);
		json.put("msg", "修改成功");
		return json.toJSONString();
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		int exist = userService.exist(user);
		JSONObject json = new JSONObject();
		if (0 != exist) {
			json.put("code", "1");
			json.put("msg", "用户名已存在");
		} else {
			json.put("code", "0");
			userService.register(user);
		}
		return json.toJSONString();
	}
	
	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping("/login")
	public String login(@RequestBody User user, HttpSession session) {
		User loginUser = userService.login(user);
		JSONObject json = new JSONObject();
		if (null == loginUser) {
			json.put("code", 1);
		} else {
			session.setAttribute("user", loginUser);
			json.put("user", loginUser);
			json.put("code", 0);
		}
		return json.toJSONString();
	}
	
	/**
	 * 注销
	 * @param session
	 */
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (null != user) {
			session.removeAttribute("user");
		}
	}
	
	/**
	 * 分页获取所有用户
	 * @param start
	 * @param size
	 * @param keyword
	 * @return
	 */
	@GetMapping("/users")
	public PageInfo<User> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<User> us = userService.list(paramMap);
		PageInfo<User> page = new PageInfo<User>(us, 5);
		return page;
	}
	
	@GetMapping("/allUsers")
	public List<User> allUsers(@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<User> us = userService.list(paramMap);
		return us;
	}
	
	/**
	 * 根据id获取单个用户
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}")
	public String get(@PathVariable("id") int id) {
		User user = userService.get(id);
		List<Role> roles = roleService.list(null);
		JSONObject json = new JSONObject();
		json.put("user", user);
		json.put("roles", roles);
		return json.toJSONString();
	}
	
	/**
	 * 获取所有角色
	 * @return
	 */
	@GetMapping("/listRoles")
	public List<Role> get() {
		List<Role> roles = roleService.list(null);
		return roles;
	}
	
	/**
	 * 为用户批量分配角色
	 * @param params
	 * @return
	 */
	@PostMapping("/usersBatch")
	public String addBatch(@RequestBody JSONObject params) {
		String[] userStrs = params.get("userIds").toString().split(",");
		Set<String> userIds = new HashSet<String>();
		for (String userStr : userStrs) {
			userIds.add(userStr);
		}
		String[] roleStrs = params.get("roleIds").toString().split(",");
		Set<String> roleIds = new HashSet<String>();
		for (String roleStr : roleStrs) {
			roleIds.add(roleStr);
		}
		userService.updateBatch(userIds, roleIds);
		return "success";
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping("/users")
	public String add(@RequestBody User user) throws NoSuchAlgorithmException {
		int exist = userService.exist(user);
		JSONObject json = new JSONObject();
		if (0 != exist) {
			json.put("code", 1);
			json.put("msg", "用户名已存在");
		} else {
			userService.add(user);
			json.put("code", 0);
			json.put("msg", "新增成功");
		}
		return json.toJSONString();
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PutMapping("/users")
	public String update(@RequestBody User user) throws NoSuchAlgorithmException {
		userService.update(user);
		return "success";
	}
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@DeleteMapping("/users/{id}")
	public String delete(@PathVariable("id") int id) {
		userService.delete(id);
		return "success";
	}
}
