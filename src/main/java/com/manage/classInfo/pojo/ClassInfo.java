package com.manage.classInfo.pojo;

/**
 * @ClassName:ClassInfo
 * @Description:学习交流实体
 * @date:2020年3月6日 上午10:49:32
 */
public class ClassInfo {
	private int id;//主键id
	private String name;//发布人账号
	private String title;//主题
	private String content;//内容
	private String createtime;//发布时间
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
