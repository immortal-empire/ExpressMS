package com.neu.ems.warehouseManagement.service;

import java.sql.Connection;

import com.neu.ems.utils.DButil;
import com.neu.ems.warehouseManagement.dao.WarehouseManagementDaoImp;

public class WarehouseManagementService {
	
	//����ģʽ
	private static WarehouseManagementService service = new WarehouseManagementService();
	public WarehouseManagementService() {
		
	}
	public static WarehouseManagementService getInstance() {
		return service;
	}

	/*
	 * ������鵥�ݵ�����������������
	 */
	public int selectPageNumber(String sql,Object object) {
		Connection conn = DButil.getConn();
		WarehouseManagementDaoImp dao = new WarehouseManagementDaoImp(conn);
		int pagenum = dao.selectPageNumber(sql, object);
		DButil.closeConn(conn);
		return pagenum;	
	}
}
