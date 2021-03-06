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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.classInfo.pojo.Message;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.service.MessageService;
import com.manage.classInfo.util.TimeUtil;

/**
 * @ClassName:MessageController
 * @Description:留言板管理
 * @date:2020年3月6日 上午10:39:22
 */
@RestController
public class MessageController {
	@Autowired MessageService messageService;
	
	/**
	 * 分页获取全部留言
	 * @param start
	 * @param size
	 * @param keyword
	 * @return
	 */
	@GetMapping("/messages")
	public PageInfo<Message> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Message> ms = messageService.list(paramMap);
		PageInfo<Message> page = new PageInfo<Message>(ms, 5);
		return page;
	}
	
	/**
	 * 根据id获取单个留言
	 * @param id
	 * @return
	 */
	@GetMapping("/messages/{id}")
	public Message get(@PathVariable("id") int id) {
		Message message = messageService.get(id);
		return message;
	}
	
	/**
	 * 新增留言
	 * @param message
	 * @param session
	 * @return
	 */
	@PostMapping("/messages")
	public String add(@RequestBody Message message, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getName();
		message.setName(userName);
		message.setCreatetime(TimeUtil.getStringDate());
		messageService.add(message);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 根据id删除留言
	 * @param id
	 * @return
	 */
	@DeleteMapping("/messages/{id}")
	public String delete(@PathVariable("id") int id) {
		messageService.delete(id);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
}
