package com.manage.classInfo.pojo;

public class MoneyIn {
	private int id;
	private String name;
	private int count;
	private String inDate;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public MoneyIn(int id, String name, int count, String inDate) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.inDate = inDate;
	}
	public MoneyIn() {
		super();
	}
}
