package com.manage.classInfo.pojo;

public class MoneyOut {
	private int id;
	private String content;
	private int count;
	private String outTime;
	private String name;
	private int leftMoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLeftMoney() {
		return leftMoney;
	}
	public void setLeftMoney(int leftMoney) {
		this.leftMoney = leftMoney;
	}
	public MoneyOut(int id, String content, int count, String outTime, String name, int leftMoney) {
		super();
		this.id = id;
		this.content = content;
		this.count = count;
		this.outTime = outTime;
		this.name = name;
		this.leftMoney = leftMoney;
	}
	public MoneyOut() {
		super();
	}
}
