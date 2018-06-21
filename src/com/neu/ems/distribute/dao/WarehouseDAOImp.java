package com.neu.ems.distribute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.neu.ems.entity.Warehouse;
import com.neu.ems.utils.DButil;

public class WarehouseDAOImp implements WarehouseDAO {
	
	Connection conn;
	
	public WarehouseDAOImp(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void addWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into Warehouse values (?,?,?,?,?)");
			ps.setString(1, warehouse.getId());
			ps.setString(2, warehouse.getName());
			ps.setString(3, warehouse.getAddress());
			ps.setString(4, warehouse.getManager());
			ps.setString(5, warehouse.getType());
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.closePs(ps);
		}
		
	}
	
	
}
