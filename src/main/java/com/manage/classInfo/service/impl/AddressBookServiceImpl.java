package com.manage.classInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.classInfo.mapper.AddressBookMapper;
import com.manage.classInfo.pojo.AddressBook;
import com.manage.classInfo.service.AddressBookService;

@Service
public class AddressBookServiceImpl implements AddressBookService {
	@Autowired AddressBookMapper addressBookMapper;
	
	@Override
	public List<AddressBook> list(Map<String, String> paramMap) {
		return addressBookMapper.list(paramMap);
	}

	@Override
	public void add(AddressBook addressBook) {
		addressBookMapper.add(addressBook);
	}
	
	@Override
	public void delete(int id) {
		addressBookMapper.delete(id);
	}

	@Override
	public void update(AddressBook addressBook) {
		addressBookMapper.update(addressBook);
	}

	@Override
	public AddressBook get(int id) {
		return addressBookMapper.get(id);
	}

}
