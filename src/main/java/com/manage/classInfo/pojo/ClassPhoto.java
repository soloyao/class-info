package com.manage.classInfo.pojo;

/**
 * @ClassName:ClassPhoto
 * @Description:班级相册实体
 * @date:2020年3月6日 上午10:49:57
 */
public class ClassPhoto {
	private int id;//主键id
	private String title;//主题
	private String content;//相册url
	private String uploadtime;//上传时间
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
