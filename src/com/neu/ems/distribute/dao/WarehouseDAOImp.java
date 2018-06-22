package com.neu.ems.distribute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		} finally {
			DButil.closePs(ps);
		}

	}

	@Override
	public Warehouse validateType(String waretype) {
		// TODO Auto-generated method stub
		Warehouse w = new Warehouse();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from warehouse where waretype = ?");
			ps.setString(1, waretype);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				w.setName(rs.getString("name"));
				w.setType(rs.getString("waretype"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DButil.closePs(ps);
		}
		return w;
	}

	@Override
	public int queryPageCount(String warename, String manager, int pageSize) {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
