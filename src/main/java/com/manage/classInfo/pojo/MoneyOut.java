package com.manage.classInfo.pojo;

public class MoneyOut {
	private int id;
	private String content;
	private double count;
	private String outTime;
	private String name;
	private double leftMoney;
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
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
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
	public double getLeftMoney() {
		return leftMoney;
	}
	public void setLeftMoney(double leftMoney) {
		this.leftMoney = leftMoney;
	}
	public MoneyOut(int id, String content, double count, String outTime, String name, double leftMoney) {
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
