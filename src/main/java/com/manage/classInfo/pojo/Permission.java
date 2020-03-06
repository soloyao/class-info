package com.manage.classInfo.pojo;

/**
 * @ClassName:Permission
 * @Description:权限实体
 * @date:2020年3月6日 上午10:51:58
 */
public class Permission {
	private int id;//主键id
	private String name;//菜单名称
	private String desc;//菜单描述
	private String url;//菜单地址
	private int pid;//父菜单id
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
