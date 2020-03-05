package com.manage.classInfo.pojo;

public class MoneyIn {
	private int id;
	private String name;
	private double count;
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
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public MoneyIn(int id, String name, double count, String inDate) {
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
