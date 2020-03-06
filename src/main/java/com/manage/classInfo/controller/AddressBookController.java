package com.manage.classInfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.manage.classInfo.pojo.AddressBook;
import com.manage.classInfo.service.AddressBookService;

/**
 * @ClassName:AddressBookController
 * @Description:通讯录管理
 * @date:2020年3月6日 上午10:30:55
 */
@RestController
public class AddressBookController {
	@Autowired AddressBookService addressBookService;
	
	/**
	 * 分页获取通讯录
	 * @param start
	 * @param size
	 * @param keyword
	 * @return
	 */
	@GetMapping("/addressBooks")
	public PageInfo<AddressBook> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<AddressBook> as = addressBookService.list(paramMap);
		PageInfo<AddressBook> page = new PageInfo<AddressBook>(as, 5);
		return page;
	}
	
	/**
	 * 根据id获取单个通讯录
	 * @param id
	 * @return
	 */
	@GetMapping("/addressBooks/{id}")
	public AddressBook get(@PathVariable("id") int id) {
		AddressBook addressBook = addressBookService.get(id);
		return addressBook;
	}
	
	/**
	 * 新增通讯录
	 * @param addressBook
	 * @return
	 */
	@PostMapping("/addressBooks")
	public String add(@RequestBody AddressBook addressBook) {
		addressBookService.add(addressBook);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 修改通讯录
	 * @param addressBook
	 * @return
	 */
	@PutMapping("/addressBooks")
	public String update(@RequestBody AddressBook addressBook) {
		addressBookService.update(addressBook);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 根据id删除通讯录
	 * @param id
	 * @return
	 */
	@DeleteMapping("/addressBooks/{id}")
	public String delete(@PathVariable("id") int id) {
		addressBookService.delete(id);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
}
