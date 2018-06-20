package com.neu.ems.distribute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.neu.ems.entity.Warehouse;

public class WarehouseDAOImp implements WarehouseDAO {
	
	Connection conn;
	
	public WarehouseDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void addWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		
	}
	
	
}
