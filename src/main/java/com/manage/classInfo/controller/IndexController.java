package com.manage.classInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login/login2");
		return mav;
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("login/register");
		return mav;
	}
	
	@GetMapping("/demo")
	public ModelAndView demo() {
		ModelAndView mav = new ModelAndView("demo");
		return mav;
	}
	
	@GetMapping("/demo2")
	public ModelAndView demo2() {
		ModelAndView mav = new ModelAndView("demo2");
		return mav;
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home/home");
		return mav;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index/index");
		return mav;
	}
	
	@GetMapping("/listCategory")
	public ModelAndView listCategory() {
		ModelAndView mav = new ModelAndView("category/listCategory");
		return mav;
	}
	
	@GetMapping("/listUser")
	public ModelAndView listUser() {
		ModelAndView mav = new ModelAndView("user/listUser");
		return mav;
	}
	
	@GetMapping("/listRole")
	public ModelAndView listRole() {
		ModelAndView mav = new ModelAndView("role/listRole");
		return mav;
	}
	
	@GetMapping("/listPermission")
	public ModelAndView listPermission() {
		ModelAndView mav = new ModelAndView("permission/listPermission");
		return mav;
	}
	
	@GetMapping("/listHotel")
	public ModelAndView listHotel() {
		ModelAndView mav = new ModelAndView("hotel/listHotel");
		return mav;
	}
	
	@GetMapping("/listAddressBook")
	public ModelAndView listAddressBook() {
		ModelAndView mav = new ModelAndView("class/listAddressBook");
		return mav;
	}
	
	@GetMapping("/listAddressBookManage")
	public ModelAndView listAddressBookManage() {
		ModelAndView mav = new ModelAndView("class/listAddressBookManage");
		return mav;
	}
	
	@GetMapping("/listPhotoManage")
	public ModelAndView listPhotoManage() {
		ModelAndView mav = new ModelAndView("class/listPhotoManage");
		return mav;
	}
	
	@GetMapping("/listPhoto")
	public ModelAndView listPhoto() {
		ModelAndView mav = new ModelAndView("class/listPhoto");
		return mav;
	}
	
	@GetMapping("/listMessageManage")
	public ModelAndView listMessageManage() {
		ModelAndView mav = new ModelAndView("class/listMessageManage");
		return mav;
	}
	
	@GetMapping("/listMessage")
	public ModelAndView listMessage() {
		ModelAndView mav = new ModelAndView("class/listMessage");
		return mav;
	}
	
	@GetMapping("/listClassInfoManage")
	public ModelAndView listClassInfoManage() {
		ModelAndView mav = new ModelAndView("class/listClassInfoManage");
		return mav;
	}
	
	@GetMapping("/listClassInfo")
	public ModelAndView listClassInfo() {
		ModelAndView mav = new ModelAndView("class/listClassInfo");
		return mav;
	}
	
}
