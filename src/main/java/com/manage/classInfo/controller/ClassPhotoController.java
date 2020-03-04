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
import com.manage.classInfo.pojo.ClassPhoto;
import com.manage.classInfo.service.ClassPhotoService;

@RestController
public class ClassPhotoController {
	@Autowired ClassPhotoService classPhotoService;
	
	@GetMapping("/classPhotos")
	public PageInfo<ClassPhoto> list(@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "size", defaultValue = "10") int size,
			@RequestParam(value = "keyword", defaultValue = "") String keyword) {
		PageHelper.startPage(start, size, "id desc");
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<ClassPhoto> cs = classPhotoService.list(paramMap);
		PageInfo<ClassPhoto> page = new PageInfo<ClassPhoto>(cs, 5);
		return page;
	}
	
	@GetMapping("/allClassPhotos")
	public List<ClassPhoto> listAll(@RequestParam(value = "keyword") String keyword) {
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<ClassPhoto> cs = classPhotoService.list(paramMap);
		return cs;
	}
	
	@GetMapping("/classPhotos/{id}")
	public ClassPhoto get(@PathVariable("id") int id) {
		ClassPhoto classPhoto = classPhotoService.get(id);
		return classPhoto;
	}
	
	@PostMapping("/classPhotos")
	public String add(@RequestBody ClassPhoto classPhoto) {
		classPhotoService.add(classPhoto);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	@PutMapping("/classPhotos")
	public String update(@RequestBody ClassPhoto classPhoto) {
		classPhotoService.update(classPhoto);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	@DeleteMapping("/classPhotos/{id}")
	public String delete(@PathVariable("id") int id) {
		classPhotoService.delete(id);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
}
