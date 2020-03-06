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

/**
 * @ClassName:ClassPhotoController
 * @Description:班级相册管理
 * @date:2020年3月6日 上午10:35:01
 */
@RestController
public class ClassPhotoController {
	@Autowired ClassPhotoService classPhotoService;
	
	/**
	 * 分页获取班级相册
	 * @param start
	 * @param size
	 * @param keyword
	 * @return
	 */
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
	
	/**
	 * 获取所有班级相册（非分页）
	 * @param keyword
	 * @return
	 */
	@GetMapping("/allClassPhotos")
	public List<ClassPhoto> listAll(@RequestParam(value = "keyword") String keyword) {
		Map<String, String> paramMap = new HashMap<String, String>();
		if (!StringUtils.isEmpty(keyword)) {
			paramMap.put("keyword", keyword);
		}
		List<ClassPhoto> cs = classPhotoService.list(paramMap);
		return cs;
	}
	
	/**
	 * 根据id获取班级相册
	 * @param id
	 * @return
	 */
	@GetMapping("/classPhotos/{id}")
	public ClassPhoto get(@PathVariable("id") int id) {
		ClassPhoto classPhoto = classPhotoService.get(id);
		return classPhoto;
	}
	
	/**
	 * 新增班级相册
	 * @param classPhoto
	 * @return
	 */
	@PostMapping("/classPhotos")
	public String add(@RequestBody ClassPhoto classPhoto) {
		classPhotoService.add(classPhoto);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 修改班级相册
	 * @param classPhoto
	 * @return
	 */
	@PutMapping("/classPhotos")
	public String update(@RequestBody ClassPhoto classPhoto) {
		classPhotoService.update(classPhoto);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
	
	/**
	 * 根据id删除班级相册
	 * @param id
	 * @return
	 */
	@DeleteMapping("/classPhotos/{id}")
	public String delete(@PathVariable("id") int id) {
		classPhotoService.delete(id);
		JSONObject json = new JSONObject();
		json.put("code", "0");
		return json.toJSONString();
	}
}
