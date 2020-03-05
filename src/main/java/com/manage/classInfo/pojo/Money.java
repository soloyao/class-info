package com.manage.classInfo.pojo;

public class Money {
	private int id;
	private int moneyCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoneyCount() {
		return moneyCount;
	}
	public void setMoneyCount(int moneyCount) {
		this.moneyCount = moneyCount;
	}
	public Money(int id, int moneyCount) {
		super();
		this.id = id;
		this.moneyCount = moneyCount;
	}
	public Money() {
		super();
	}
}
