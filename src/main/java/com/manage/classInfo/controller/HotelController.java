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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.classInfo.pojo.Hotel;
import com.manage.classInfo.service.HotelService;

@RestController
public class HotelController {
	@Autowired HotelService hotelService;
	
	@GetMapping("/hotels")
	public PageInfo<Hotel> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Hotel> hs = hotelService.list(paramMap);
		PageInfo<Hotel> page = new PageInfo<Hotel>(hs, 5);
		return page;
	}
	
	@GetMapping("/hotels/{id}")
	public Hotel get(@PathVariable("id") int id) {
		Hotel hotel = hotelService.get(id);
		return hotel;
	}
	
	@PostMapping("/hotels")
	public String add(@RequestBody Hotel hotel) {
		hotelService.add(hotel);
		return "success";
	}
	
	@PutMapping("/hotels")
	public String update(@RequestBody Hotel hotel) {
		hotelService.update(hotel);
		return "success";
	}
	
	@DeleteMapping("/hotels/{id}")
	public String delete(@PathVariable("id") int id) {
		hotelService.delete(id);
		return "success";
	}
}
