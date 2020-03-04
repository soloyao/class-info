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
import com.manage.classInfo.pojo.Category;
import com.manage.classInfo.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired CategoryService categoryService;
	
	@GetMapping("/categories")
	public PageInfo<Category> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<Category> cs = categoryService.list(paramMap);
		PageInfo<Category> page = new PageInfo<Category>(cs, 5);
		return page;
	}
	
	@GetMapping("/categories/{id}")
	public Category get(@PathVariable("id") int id) {
		Category category = categoryService.get(id);
		return category;
	}
	
	@PostMapping("/categories")
	public String add(@RequestBody Category category) {
		categoryService.add(category);
		return "success";
	}
	
	@PutMapping("/categories")
	public String update(@RequestBody Category category) {
		categoryService.update(category);
		return "success";
	}
	
	@DeleteMapping("/categories/{id}")
	public String delete(@PathVariable("id") int id) {
		categoryService.delete(id);
		return "success";
	}
}
