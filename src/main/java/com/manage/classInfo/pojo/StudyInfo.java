package com.manage.classInfo.pojo;

/**
 * @ClassName:StudyInfo
 * @Description:学习交流实体
 * @date:2020年3月6日 上午10:53:33
 */
public class StudyInfo {
	private int id;//主键id
	private String title;//主题
	private String content;//内容
	private String name;//发布人
	private String createtime;//发布时间
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public StudyInfo(int id, String title, String content, String name, String createtime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.name = name;
		this.createtime = createtime;
	}
	public StudyInfo() {
		super();
	}
}
