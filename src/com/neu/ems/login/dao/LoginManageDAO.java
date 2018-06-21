package com.neu.ems.login.dao;

import java.util.Map;

import com.neu.ems.entity.Administrator;

public interface LoginManageDAO {

	String getUserType(Administrator administrator);

	Map<String, Integer> getdataNum();
	

}
