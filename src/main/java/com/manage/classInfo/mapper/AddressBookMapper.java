package com.manage.classInfo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.manage.classInfo.pojo.AddressBook;

@Mapper
public interface AddressBookMapper {
	List<AddressBook> list(Map<String, String> paramMap);
	void add(AddressBook addressBook);
	void delete(int id);
	void update(AddressBook addressBook);
	AddressBook get(int id);
}
