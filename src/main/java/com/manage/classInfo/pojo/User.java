package com.manage.classInfo.pojo;

import java.util.List;

/**
 * @ClassName:User
 * @Description:用户实体
 * @date:2020年3月6日 上午10:54:04
 */
public class User {
	private int id;//主键id
	private String name;//账号
	private String password;//密码
	private String phone;//电话
	private String realname;//姓名
	private String sex;//性别
	private List<Role> roles;//所有角色
	private double money;//班费
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
