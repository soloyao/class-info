package com.manage.classInfo.pojo;

/**
 * @ClassName:MoneyIn
 * @Description:班费缴纳实体
 * @date:2020年3月6日 上午10:50:57
 */
public class MoneyIn {
	private int id;//主键id
	private String name;//缴纳人账号
	private double count;//缴纳金额
	private String inDate;//缴纳日期
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
