package com.neu.ems.login.service;

import java.sql.Connection;
import java.util.Map;

import com.neu.ems.distribute.dao.WarehouseDAO;
import com.neu.ems.distribute.dao.WarehouseDAOImp;
import com.neu.ems.entity.Administrator;
import com.neu.ems.entity.Warehouse;
import com.neu.ems.login.dao.LoginManageDAO;
import com.neu.ems.login.dao.LoginManageDAOImp;
import com.neu.ems.utils.DButil;

public class LoginManageService {
	
	private LoginManageService() {
		
	}

	private static LoginManageService service = new LoginManageService();
	
	public static LoginManageService getInstance() {
		return service;
	}
	

	public String getUserType(Administrator administrator) {
		// TODO Auto-generated method stub
		Connection conn = DButil.getConn();
		DButil.Transcation(conn);
		String usertype = null;
		
		try {
			LoginManageDAO logindao = new LoginManageDAOImp(conn);
			usertype = logindao.getUserType(administrator);
			
			DButil.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DButil.rollback(conn);
		} finally {
			DButil.closeConn(conn);
		}
		return usertype;
	}

	public Map<String, Integer> getdataNum() {
		// TODO Auto-generated method stub
		Connection conn = DButil.getConn();
		DButil.Transcation(conn);
		Map<String, Integer> map = null;
		
		try {
			LoginManageDAO logindao = new LoginManageDAOImp(conn);
			map = logindao.getdataNum();
			
			DButil.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DButil.rollback(conn);
		} finally {
			DButil.closeConn(conn);
		}
		return map;
	}
}
