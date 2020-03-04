package com.manage.classInfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.manage.classInfo.pojo.ClassInfo;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.service.ClassInfoService;
import com.manage.classInfo.util.TimeUtil;

@RestController
public class ClassInfoController {
	@Autowired ClassInfoService classInfoService;
	
	@GetMapping("/classInfos")
	public PageInfo<ClassInfo> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<ClassInfo> cs = classInfoService.list(paramMap);
		PageInfo<ClassInfo> page = new PageInfo<ClassInfo>(cs, 5);
		return page;
	}
	
	@GetMapping("/classInfos/{id}")
	public ClassInfo get(@PathVariable("id") int id) {
		ClassInfo classInfo = classInfoService.get(id);
		return classInfo;
	}
	
	@PostMapping("/classInfos")
	public String add(@RequestBody ClassInfo classInfo, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getName();
		classInfo.setName(userName);
		classInfo.setCreatetime(TimeUtil.getStringDate());
		classInfoService.add(classInfo);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	@PutMapping("/classInfos")
	public String update(@RequestBody ClassInfo classInfo, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getName();
		classInfo.setName(userName);
		classInfo.setCreatetime(TimeUtil.getStringDate());
		classInfoService.update(classInfo);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	@DeleteMapping("/classInfos/{id}")
	public String delete(@PathVariable("id") int id) {
		classInfoService.delete(id);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
}
