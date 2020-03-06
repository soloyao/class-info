package com.manage.classInfo.pojo;

/**
 * @ClassName:UserRole
 * @Description:用户角色中间实体
 * @date:2020年3月6日 上午10:54:48
 */
public class UserRole {
	private int id;//主键id
	private int uid;//用户id
	private int rid;//角色id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
}
