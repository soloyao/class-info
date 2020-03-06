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

/**
 * @ClassName:ClassInfoController
 * @Description:班级消息管理
 * @date:2020年3月6日 上午10:32:00
 */
@RestController
public class ClassInfoController {
	@Autowired ClassInfoService classInfoService;
	
	/**
	 * 分页获取班级消息
	 * @param start
	 * @param size
	 * @param keyword
	 * @return
	 */
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
	
	/**
	 * 根据id获取单个班级消息
	 * @param id
	 * @return
	 */
	@GetMapping("/classInfos/{id}")
	public ClassInfo get(@PathVariable("id") int id) {
		ClassInfo classInfo = classInfoService.get(id);
		return classInfo;
	}
	
	/**
	 * 新增班级消息
	 * @param classInfo
	 * @param session
	 * @return
	 */
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
	
	/**
	 * 修改班级消息
	 * @param classInfo
	 * @param session
	 * @return
	 */
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
	
	/**
	 * 根据id删除班级消息
	 * @param id
	 * @return
	 */
	@DeleteMapping("/classInfos/{id}")
	public String delete(@PathVariable("id") int id) {
		classInfoService.delete(id);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
}
