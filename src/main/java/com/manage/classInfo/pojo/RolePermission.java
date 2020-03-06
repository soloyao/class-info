package com.manage.classInfo.pojo;

/**
 * @ClassName:RolePermission
 * @Description:角色菜单中间实体
 * @date:2020年3月6日 上午10:53:03
 */
public class RolePermission {
	private int id;//主键id
	private int rid;//角色id
	private int pid;//菜单id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
}
