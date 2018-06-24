package com.neu.ems.distribute.service;

import java.sql.Connection;
import java.util.List;

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

	public boolean validateType(String waretype) {
		// TODO Auto-generated method stub
		Connection conn = DButil.getConn();
		WarehouseDAO dao = new WarehouseDAOImp(conn);
		Warehouse w = dao.validateType(waretype);
		DButil.closeConn(conn);
		if(w == null) {
			return true;
		}else {
			return false;
		}
		
	}

	public int queryPageCount(String warename, String manager, int pageSize) {
		// TODO Auto-generated method stub
		Connection conn = DButil.getConn();
		WarehouseDAO dao = new WarehouseDAOImp(conn);
		return dao.queryPageCount(warename, manager, pageSize);
	}

	public List<Warehouse> queryWarehouse(String warename, String manager, int pageSize, int pageIndex) {
		// TODO Auto-generated method stub
		Connection conn = DButil.getConn();
		WarehouseDAO dao = new WarehouseDAOImp(conn);
		return dao.queryWarehouse(warename, manager, pageSize, pageIndex);
	}

	public void editWarehouse(Warehouse w) {
		// TODO Auto-generated method stub
		Connection conn = DButil.getConn();
		DButil.Transcation(conn);

		try {
			WarehouseDAO warehousedao = new WarehouseDAOImp(conn);
			warehousedao.editWarehouse(w);

			DButil.commit(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DButil.rollback(conn);
		} finally {
			DButil.closeConn(conn);
		}
	}

}
