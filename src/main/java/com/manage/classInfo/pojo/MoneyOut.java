package com.manage.classInfo.pojo;

/**
 * @ClassName:MoneyOut
 * @Description:班费支出实体
 * @date:2020年3月6日 上午10:51:23
 */
public class MoneyOut {
	private int id;//主键id
	private String content;//用作
	private double count;//支出金额
	private String outTime;//支出时间
	private String name;//经办人
	private double leftMoney;//剩余总班费
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
