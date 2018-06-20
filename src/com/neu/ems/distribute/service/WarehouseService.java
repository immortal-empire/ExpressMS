package com.neu.ems.distribute.service;

import java.sql.Connection;

import com.neu.ems.distribute.dao.WarehouseDAO;
import com.neu.ems.distribute.dao.WarehouseDAOImp;
import com.neu.ems.entity.Warehouse;
import com.neu.ems.utils.DButil;

public class WarehouseService {
	
	private WarehouseService() {
		
	}
	
	private static WarehouseService service = new WarehouseService();
	
	public static WarehouseService getInstance() {
		return service;
	}

	public void addWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
		Connection conn = DButil.getConn();
		DButil.Transcation(conn);
		
		try {
			WarehouseDAO warehousedao = new WarehouseDAOImp(conn);
			warehousedao.addWarehouse(warehouse);
			
			DButil.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DButil.rollback(conn);
		} finally {
			DButil.closeConn(conn);
		}
		
		
	}
	
	
}
