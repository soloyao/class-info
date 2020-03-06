package com.manage.classInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	/**
	 * 跳转至登录页面
	 * @return
	 */
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login/login2");
		return mav;
	}
	
	/**
	 * 跳转至注册页面
	 * @return
	 */
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("login/register");
		return mav;
	}
	
	/**
	 * 跳转至首页
	 * @return
	 */
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home/home");
		return mav;
	}
	
	/**
	 * 跳转至系统管理页面
	 * @return
	 */
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index/index");
		return mav;
	}
	
	/**
	 * 跳转至用户管理页面
	 * @return
	 */
	@GetMapping("/listUser")
	public ModelAndView listUser() {
		ModelAndView mav = new ModelAndView("user/listUser");
		return mav;
	}
	
	/**
	 * 跳转至角色管理页面
	 * @return
	 */
	@GetMapping("/listRole")
	public ModelAndView listRole() {
		ModelAndView mav = new ModelAndView("role/listRole");
		return mav;
	}
	
	/**
	 * 跳转至权限管理页面
	 * @return
	 */
	@GetMapping("/listPermission")
	public ModelAndView listPermission() {
		ModelAndView mav = new ModelAndView("permission/listPermission");
		return mav;
	}
	
	/**
	 * 跳转至通讯录页面
	 * @return
	 */
	@GetMapping("/listAddressBook")
	public ModelAndView listAddressBook() {
		ModelAndView mav = new ModelAndView("class/listAddressBook");
		return mav;
	}
	
	/**
	 * 跳转至通讯录管理页面
	 * @return
	 */
	@GetMapping("/listAddressBookManage")
	public ModelAndView listAddressBookManage() {
		ModelAndView mav = new ModelAndView("class/listAddressBookManage");
		return mav;
	}
	
	/**
	 * 跳转至班级相册管理页面
	 * @return
	 */
	@GetMapping("/listPhotoManage")
	public ModelAndView listPhotoManage() {
		ModelAndView mav = new ModelAndView("class/listPhotoManage");
		return mav;
	}
	
	/**
	 * 跳转至班级相册页面
	 * @return
	 */
	@GetMapping("/listPhoto")
	public ModelAndView listPhoto() {
		ModelAndView mav = new ModelAndView("class/listPhoto");
		return mav;
	}
	
	/**
	 * 跳转至留言板管理页面
	 * @return
	 */
	@GetMapping("/listMessageManage")
	public ModelAndView listMessageManage() {
		ModelAndView mav = new ModelAndView("class/listMessageManage");
		return mav;
	}
	
	/**
	 * 跳转至留言板页面
	 * @return
	 */
	@GetMapping("/listMessage")
	public ModelAndView listMessage() {
		ModelAndView mav = new ModelAndView("class/listMessage");
		return mav;
	}
	
	/**
	 * 跳转至班级消息管理页面
	 * @return
	 */
	@GetMapping("/listClassInfoManage")
	public ModelAndView listClassInfoManage() {
		ModelAndView mav = new ModelAndView("class/listClassInfoManage");
		return mav;
	}
	
	/**
	 * 跳转至班级消息页面
	 * @return
	 */
	@GetMapping("/listClassInfo")
	public ModelAndView listClassInfo() {
		ModelAndView mav = new ModelAndView("class/listClassInfo");
		return mav;
	}
	
	/**
	 * 跳转至班费缴纳管理页面
	 * @return
	 */
	@GetMapping("/listMoneyInManage")
	public ModelAndView listMoneyInManage() {
		ModelAndView mav = new ModelAndView("class/listMoneyInManage");
		return mav;
	}
	
	/**
	 * 跳转至班费支出管理页面
	 * @return
	 */
	@GetMapping("/listMoneyOutManage")
	public ModelAndView listMoneyOutManage() {
		ModelAndView mav = new ModelAndView("class/listMoneyOutManage");
		return mav;
	}
	
	/**
	 * 跳转至班费支出页面
	 * @return
	 */
	@GetMapping("/listMoneyOut")
	public ModelAndView listMoneyOut() {
		ModelAndView mav = new ModelAndView("class/listMoneyOut");
		return mav;
	}
	
	/**
	 * 跳转至学习交流管理页面
	 * @return
	 */
	@GetMapping("/listStudyInfoManage")
	public ModelAndView listStudyInfoManage() {
		ModelAndView mav = new ModelAndView("class/listStudyInfoManage");
		return mav;
	}
	
	/**
	 * 跳转至学习交流页面
	 * @return
	 */
	@GetMapping("/listStudyInfo")
	public ModelAndView listStudyInfo() {
		ModelAndView mav = new ModelAndView("class/listStudyInfo");
		return mav;
	}
	
}
