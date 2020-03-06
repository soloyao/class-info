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
import com.manage.classInfo.pojo.StudyInfo;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.service.StudyInfoService;
import com.manage.classInfo.util.TimeUtil;

/**
 * @ClassName:StudyInfoController
 * @Description:学习交流管理
 * @date:2020年3月6日 上午10:44:54
 */
@RestController
public class StudyInfoController {
	@Autowired StudyInfoService studyInfoService;
	
	/**
	 * 分页获取所有学习交流信息
	 * @param start
	 * @param size
	 * @param keyword
	 * @return
	 */
	@GetMapping("/studyInfos")
	public PageInfo<StudyInfo> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<StudyInfo> ss = studyInfoService.list(paramMap);
		PageInfo<StudyInfo> page = new PageInfo<StudyInfo>(ss, 5);
		return page;
	}
	
	/**
	 * 根据id获取单个学习交流信息
	 * @param id
	 * @return
	 */
	@GetMapping("/studyInfos/{id}")
	public StudyInfo get(@PathVariable("id") int id) {
		StudyInfo studyInfo = studyInfoService.get(id);
		return studyInfo;
	}
	
	/**
	 * 新增学习交流信息
	 * @param studyInfo
	 * @param session
	 * @return
	 */
	@PostMapping("/studyInfos")
	public String add(@RequestBody StudyInfo studyInfo, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getName();
		studyInfo.setName(userName);
		studyInfo.setCreatetime(TimeUtil.getStringDate());
		studyInfoService.add(studyInfo);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 修改学习交流信息
	 * @param studyInfo
	 * @param session
	 * @return
	 */
	@PutMapping("/studyInfos")
	public String update(@RequestBody StudyInfo studyInfo, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getName();
		studyInfo.setName(userName);
		studyInfo.setCreatetime(TimeUtil.getStringDate());
		studyInfoService.update(studyInfo);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 根据id删除学习交流信息
	 * @param id
	 * @return
	 */
	@DeleteMapping("/studyInfos/{id}")
	public String delete(@PathVariable("id") int id) {
		studyInfoService.delete(id);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
}
