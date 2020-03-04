package com.manage.classInfo.service;

import java.util.List;
import java.util.Map;

import com.manage.classInfo.pojo.AddressBook;

public interface AddressBookService {
	List<AddressBook> list(Map<String, String> paramMap);
	void add(AddressBook addressBook);
	void delete(int id);
	void update(AddressBook addressBook);
	AddressBook get(int id);
}
