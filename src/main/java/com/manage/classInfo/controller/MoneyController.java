package com.manage.classInfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.classInfo.pojo.MoneyIn;
import com.manage.classInfo.pojo.MoneyOut;
import com.manage.classInfo.pojo.User;
import com.manage.classInfo.service.MoneyInService;
import com.manage.classInfo.service.MoneyOutService;

/**
 * @ClassName:MoneyController
 * @Description:班费管理
 * @date:2020年3月6日 上午10:40:10
 */
@RestController
public class MoneyController {
	@Autowired MoneyInService moneyInService;
	@Autowired MoneyOutService moneyOutService;
	
	/**
	 * 新增班费缴纳
	 * @param moneyIn
	 * @return
	 */
	@PostMapping("/moneyIns")
	public String add(@RequestBody MoneyIn moneyIn) {
		moneyInService.add(moneyIn);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 新增班费支出
	 * @param moneyOut
	 * @param session
	 * @return
	 */
	@PostMapping("/moneyOuts")
	public String moneyOut(@RequestBody MoneyOut moneyOut, HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userName = user.getName();
		moneyOutService.add(moneyOut, userName);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 获取班费总额
	 * @return
	 */
	@GetMapping("/allMoney")
	public double allMoney() {
		return moneyInService.allMoney();
	}
	
	/**
	 * 分页获取班费支出记录
	 * @param start
	 * @param size
	 * @param keyword
	 * @return
	 */
	@GetMapping("/moneyOuts")
	public PageInfo<MoneyOut> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<MoneyOut> ms = moneyOutService.list(paramMap);
		PageInfo<MoneyOut> page = new PageInfo<MoneyOut>(ms, 5);
		return page;
	}
}
