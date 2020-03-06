package com.manage.classInfo.pojo;

import java.util.List;

/**
 * @ClassName:Role
 * @Description:角色实体
 * @date:2020年3月6日 上午10:52:29
 */
public class Role {
	private int id;//主键id
	private String name;//角色名称
	private String desc;//角色描述
	private List<Permission> permissions;//所有菜单
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
