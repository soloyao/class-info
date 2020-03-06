package com.manage.classInfo.pojo;

/**
 * @ClassName:AddressBook
 * @Description:通讯录实体
 * @date:2020年3月6日 上午10:48:28
 */
public class AddressBook {
	private int id;//主键id
	private String studyNumber;//学号
	private String name;//姓名
	private String nativePlace;//籍贯
	private String phone;//电话
	private String qqNumber;//QQ
	private String address;//家庭地址
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudyNumber() {
		return studyNumber;
	}
	public void setStudyNumber(String studyNumber) {
		this.studyNumber = studyNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AddressBook(int id, String studyNumber, String name, String nativePlace, String phone, String qqNumber,
			String address) {
		super();
		this.id = id;
		this.studyNumber = studyNumber;
		this.name = name;
		this.nativePlace = nativePlace;
		this.phone = phone;
		this.qqNumber = qqNumber;
		this.address = address;
	}
	public AddressBook() {
		super();
	}
}
