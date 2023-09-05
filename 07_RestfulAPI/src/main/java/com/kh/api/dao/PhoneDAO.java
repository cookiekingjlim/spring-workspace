package com.kh.api.dao;

import java.util.List;

import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

public interface PhoneDAO {	// impl -> PhoneDAOImpl
	
	int insert(Phone phone);
	int update(Phone phone);
	int delete(String num);
	Phone select(String num);
	List<Phone> select();
	UserInfo select(UserInfo user);
}
