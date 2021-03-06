package com.manage.classInfo.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.manage.classInfo.pojo.Permission;
import com.manage.classInfo.pojo.Role;
import com.manage.classInfo.service.PermissionService;
import com.manage.classInfo.service.RoleService;

/**
 * @ClassName:RoleController
 * @Description:角色管理
 * @date:2020年3月6日 上午10:43:41
 */
@RestController
public class RoleController {
	@Autowired RoleService roleService;
	@Autowired PermissionService permissionService;
	JSONObject json = new JSONObject();
	
	/**
	 * 分页获取所有角色
	 * @param start
	 * @param size
	 * @param keyword
	 * @return
	 */
	@GetMapping("/roles")
	public PageInfo<Role> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Role> rs = roleService.list(paramMap);
		PageInfo<Role> page = new PageInfo<Role>(rs, 5);
		return page;
	}
	
	/**
	 * 根据id获取单个角色
	 * @param id
	 * @return
	 */
	@GetMapping("/roles/{id}")
	public String get(@PathVariable("id") int id) {
		Role role = roleService.get(id);
		List<Permission> permissions = permissionService.list(null);
		json.put("role", role);
		json.put("permissions", permissions);
		return json.toJSONString();
	}
	
	/**
	 * 获取所有菜单
	 * @return
	 */
	@GetMapping("/listPermissions")
	public List<Permission> get() {
		List<Permission> permissions = permissionService.listPermissions();
		return permissions;
	}
	
	/**
	 * 为角色批量分配菜单
	 * @param params
	 * @return
	 */
	@PostMapping("/rolesBatch")
	public String addBatch(@RequestBody JSONObject params) {
		String[] roleStrs = params.get("roleIds").toString().split(",");
		Set<String> roleIds = new HashSet<String>();
		for (String roleStr : roleStrs) {
			roleIds.add(roleStr);
		}
		String[] permissionStrs = params.get("permissionIds").toString().split(",");
		Set<String> permissionIds = new HashSet<String>();
		for (String permissionStr : permissionStrs) {
			permissionIds.add(permissionStr);
		}
		roleService.updateBatch(roleIds, permissionIds);
		return "success";
	}
	
	/**
	 * 新增橘色
	 * @param role
	 * @return
	 */
	@PostMapping("/roles")
	public String add(@RequestBody Role role) {
		int exist = roleService.exist(role);
		if (0 != exist) {
			json.put("code", 1);
			json.put("msg", "角色名已存在");
		} else {
			roleService.add(role);
			json.put("code", 0);
			json.put("msg", "新增成功");
		}
		return json.toJSONString();
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@PutMapping("/roles")
	public String update(@RequestBody Role role) {
		roleService.update(role);
		return "success";
	}
	
	/**
	 * 根据id删除角色
	 * @param id
	 * @return
	 */
	@DeleteMapping("/roles/{id}")
	public String delete(@PathVariable("id") int id) {
		roleService.delete(id);
		return "success";
	}
}
