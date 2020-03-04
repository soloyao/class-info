package com.manage.classInfo.pojo;

public class ClassInfo {
	private int id;
	private String name;
	private String title;
	private String content;
	private String createtime;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public ClassInfo(int id, String name, String title, String content, String createtime) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
	}
	public ClassInfo() {
		super();
	}
}
