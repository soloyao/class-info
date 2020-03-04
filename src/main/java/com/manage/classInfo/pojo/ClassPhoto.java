package com.manage.classInfo.pojo;

public class ClassPhoto {
	private int id;
	private String title;
	private String content;
	private String uploadtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public ClassPhoto(int id, String title, String content, String uploadtime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.uploadtime = uploadtime;
	}
	public ClassPhoto() {
		super();
	}
}
